package com.example.di.saludos;

/**
 * Contrato: cualquier "saludador" sabe saludar a alguien.
 * El controlador depende de ESTA interfaz, no de un idioma concreto.
 */
public interface Saludador {

    String saludar(String nombre);
}
