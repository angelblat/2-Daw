package com.example.demo5.repositories.entity;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Cliente {
    private Long id;
    private String nif;
    private String nombre;
    private String apellidos;
    private String claveSeguridad;
    private String email;
    private Recomendacion recomendacion;


    @ToString.Exclude
    private List<Cuenta> listaCuentas;

    public Cliente() {
        super();
        this.recomendacion = new Recomendacion();
        this.listaCuentas = new ArrayList<Cuenta>();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}


