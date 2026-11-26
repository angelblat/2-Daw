package com.example.di.saludos;

import org.springframework.stereotype.Component;

/**
 * Implementación 1: saluda en castellano.
 * @Component = "Spring, crea un objeto de esta clase y guárdalo
 *               para dárselo a quien lo pida".
 */
@Component
public class SaludadorCastellano implements Saludador {

    @Override
    public String saludar(String nombre) {
        return "¡Hola, " + nombre + "! Bienvenido/a a Spring Boot";
    }
}
