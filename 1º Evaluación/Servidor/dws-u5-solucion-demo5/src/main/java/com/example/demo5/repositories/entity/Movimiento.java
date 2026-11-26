package com.example.demo5.repositories.entity;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Data
public class Movimiento {
    private Long id;
    private String tipo;
    private LocalDate fechaOperacion;
    private String descripcion;
    private Double importe;

    @ToString.Exclude
    private Cuenta cuentaOrigen;

    @ToString.Exclude
    private Cuenta cuentaDestino;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Movimiento other = (Movimiento) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
