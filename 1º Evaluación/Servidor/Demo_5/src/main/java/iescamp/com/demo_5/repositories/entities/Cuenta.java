package iescamp.com.demo_5.repositories.entities;

import lombok.Data;

import java.util.Objects;

@Data
public class Cuenta {

    private Long id;
    private String dc;
    private String banco;
    private String sucursal;
    private String numeroCuenta;
    private double saldoCuenta;
    private Cliente cliente;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cuenta cuenta = (Cuenta) o;
        return Objects.equals(id, cuenta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
