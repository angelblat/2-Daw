# Inyección de dependencias por constructor · Spring Boot (2º DAW)

Un controlador REST que saluda. Sirve para entender **qué es la inyección de dependencias** y **por qué se recomienda hacerla por constructor**, usando solo lo que ya conocemos: `@RestController`, `@GetMapping` y `@RequestParam`.

## Cómo arrancarlo

1. En IntelliJ: *File → Open* y elige la carpeta `springboot-di` (la que contiene `pom.xml`). Espera a que Maven descargue las dependencias.
2. Abre `SpringbootDiApplication` y pulsa ▶.
3. En la consola debe aparecer `Tomcat started on port 8080`.
4. Prueba en el navegador o en Postman:
   - `http://localhost:8080/saludo?nombre=Ana` → `¡Hola, Ana! Bienvenido/a a Spring Boot`
   - `http://localhost:8080/saludo` → saluda a "alumno"

Requisitos: Java 17 o superior.

## La idea

```text
SaludoController ──necesita──▶ Saludador (interfaz)
                                   ▲ implementan
                     SaludadorCastellano   SaludadorValenciano
```

El controlador **pide** en su constructor lo que necesita y **nunca** hace `new`. Spring crea el objeto (un *bean*, gracias a `@Component`) y se lo pasa al arrancar:

```java
@RestController
public class SaludoController {

    private final Saludador saludador;            // final: nunca será null

    public SaludoController(Saludador saludador) { // Spring lo inyecta aquí
        this.saludador = saludador;
    }
}
```

## ¿Por qué por constructor?

| | Por campo (`@Autowired` en el atributo) | Por constructor (este proyecto) |
| --- | --- | --- |
| ¿Se puede olvidar la dependencia? | Sí: `new SaludoController()` compila y falla después con `NullPointerException` | No: sin pasarla, no compila |
| `final` | No | Sí |
| ¿Funciona sin Spring? | No, el campo queda `null` | Sí (ver `manual/SinSpring.java`) |
| ¿Se ve lo que necesita la clase? | Hay que buscar los `@Autowired` | Basta con leer el constructor |
| `@Autowired` | Obligatorio | Innecesario con un solo constructor |

## Experimentos para clase

En cada uno: **predice** qué pasará, **ejecuta** y **explica** lo que has visto. Deshaz el cambio antes de pasar al siguiente.

1. **Sin Spring.** Ejecuta el `main` de `manual/SinSpring.java` (no hace falta arrancar la app). Crea el saludador con `new` y se lo pasa al controlador: lo mismo que hace Spring. Cambia la línea por `new SaludadorValenciano()`: ¿has tenido que tocar el controlador?
2. **Olvidar la dependencia.** En `SinSpring`, escribe `new SaludoController()` sin argumentos. ¿Qué pasa? (No compila: el constructor te obliga a dársela.)
3. **Quitar `@Component`.** Comenta `@Component` en `SaludadorCastellano` y reinicia la app. ¿Arranca? ¿Qué dice el error? (Spring no tiene ningún `Saludador` que darle al controlador.)
4. **Dos implementaciones.** Deja `SaludadorCastellano` como estaba y, en `SaludadorValenciano`, quita el comentario de `@Component`. Reinicia. ¿Arranca? Lee el error.
5. **Elegir una.** Quita ahora también el comentario de `@Primary` y reinicia. Abre `/saludo?nombre=Ana`. ¿En qué idioma saluda? ¿Has tocado el controlador?
6. **Comparar con inyección por campo.** Cambia `SaludoController` a:
   ```java
   @Autowired
   private Saludador saludador;
   ```
   (borra el constructor y el `final`). La app funciona igual. Ahora vuelve a `SinSpring` y escribe `new SaludoController()`: compila… ¿qué pasa al ejecutarlo?

## Estructura

```text
src/main/java/com/example/di/
├── SpringbootDiApplication.java   ← main + @SpringBootApplication
├── controllers/SaludoController.java
├── saludos/Saludador.java, SaludadorCastellano.java, SaludadorValenciano.java
└── manual/SinSpring.java          ← lo que hace Spring, hecho a mano
```
