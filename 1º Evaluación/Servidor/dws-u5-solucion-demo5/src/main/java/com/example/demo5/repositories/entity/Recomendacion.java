package com.example.demo5.repositories.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Objects;

@Data
public class Recomendacion {
    private Long id;
    private String observaciones;
    @ToString.Exclude
    private Cliente cliente;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Recomendacion other = (Recomendacion) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}