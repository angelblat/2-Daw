package com.example.di.saludos;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Implementación 2: saluda en valenciano.
 *
 * EXPERIMENTO: esta clase NO tiene @Component, así que Spring la ignora.
 *   1. Quita el comentario de @Component y reinicia la app:
 *      NO arranca ("expected single matching bean but found 2").
 *      Spring no sabe qué saludador darle al controlador.
 *   2. Quita también el comentario de @Primary y reinicia:
 *      ahora /saludo responde en valenciano.
 * Fíjate: el controlador NO se ha tocado.
 */
//@Component
//@Primary
public class SaludadorValenciano implements Saludador {

    @Override
    public String saludar(String nombre) {
        return "Bon dia, " + nombre + "! Benvingut/da a Spring Boot";
    }
}
