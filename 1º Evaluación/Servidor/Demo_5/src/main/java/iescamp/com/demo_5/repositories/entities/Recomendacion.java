package iescamp.com.demo_5.repositories.entities;

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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Recomendacion that = (Recomendacion) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
