package com.example.di.manual;

import com.example.di.controllers.SaludoController;
import com.example.di.saludos.Saludador;
import com.example.di.saludos.SaludadorCastellano;
import com.example.di.saludos.SaludadorValenciano;

/**
 * LO QUE SPRING HACE POR NOSOTROS, HECHO A MANO.
 *
 * Ejecuta este main (botón ▶ junto a "main") SIN arrancar la app de Spring.
 * Como el controlador recibe su dependencia por el constructor,
 * podemos crearla nosotros con "new" y pasársela, igual que hace Spring.
 */
public class SinSpring {

    public static void main(String[] args) {
        // 1. Creamos la dependencia. Cambia esta línea por SaludadorValenciano
        //    y observa que SaludoController no cambia.
        Saludador saludador = new SaludadorCastellano();
        // Saludador saludador = new SaludadorValenciano();

        // 2. Se la "inyectamos" al controlador por su constructor
        SaludoController controller = new SaludoController(saludador);

        // 3. Lo usamos como haría Spring al recibir GET /saludo?nombre=Ana
        System.out.println(controller.saludo("Ana"));

        // PREGUNTA PARA CLASE: ¿qué pasa si escribes new SaludoController() sin argumentos?
    }
}
