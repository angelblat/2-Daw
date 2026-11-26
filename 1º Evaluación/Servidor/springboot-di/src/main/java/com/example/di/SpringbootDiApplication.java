package com.example.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal. @SpringBootApplication hace que Spring busque componentes
 * (@RestController, @Component...) en este paquete y en sus subpaquetes,
 * cree un objeto (bean) de cada uno y los conecte entre sí.
 */
@SpringBootApplication
public class SpringbootDiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDiApplication.class, args);
    }
}
