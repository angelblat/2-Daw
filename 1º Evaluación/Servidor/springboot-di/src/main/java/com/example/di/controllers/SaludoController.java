package com.example.di.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.di.saludos.Saludador;

/**
 * INYECCIÓN POR CONSTRUCTOR.
 *
 * - El controlador NECESITA un Saludador (es su dependencia).
 * - No lo crea él: no hay ningún "new SaludadorCastellano()".
 * - Lo PIDE en el constructor. Al arrancar, Spring busca un @Component
 *   que implemente Saludador y se lo pasa.
 * - "final": una vez asignado, no puede cambiar ni quedarse a null.
 * - Con un solo constructor no hace falta poner @Autowired.
 */
@RestController
public class SaludoController {

    private final Saludador saludador;

    public SaludoController(Saludador saludador) {
        this.saludador = saludador;
    }

    // http://localhost:8080/saludo?nombre=Ana
    @GetMapping("/saludo")
    public String saludo(@RequestParam(required = false, defaultValue = "alumno") String nombre) {
        return saludador.saludar(nombre);
    }
}
