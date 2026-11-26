package com.example.demo5.repositories.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo5.repositories.entity.Cuenta;
import com.example.demo5.repositories.entity.Movimiento;

@Repository
public class MovimientoRepositoryImpl implements MovimientoRepository {

    private static List<Movimiento> datos = new ArrayList<Movimiento>();

    static {

        Cuenta cu1 = new Cuenta();
        cu1.setId(1L);   // Antonio
        Cuenta cu2 = new Cuenta();
        cu2.setId(2L);   // Antonio

        Movimiento m1 = new Movimiento();
        m1.setId((long) (datos.size() + 1));
        m1.setTipo("Transferencia");
        m1.setFechaOperacion(LocalDate.of(2026, 10, 1));
        m1.setImporte(200.0);
        m1.setDescripcion("Ahorro octubre");
        m1.setCuentaOrigen(cu1);
        m1.setCuentaDestino(cu2);
        datos.add(m1);

        Movimiento m2 = new Movimiento();
        m2.setId((long) (datos.size() + 1));
        m2.setTipo("Transferencia");
        m2.setFechaOperacion(LocalDate.of(2026, 10, 15));
        m2.setImporte(50.0);
        m2.setDescripcion("Devolución");
        m2.setCuentaOrigen(cu2);
        m2.setCuentaDestino(cu1);
        datos.add(m2);
    }

    @Override
    public List<Movimiento> findAllByCuenta(Cuenta cuenta) {
        List<Movimiento> movimientosCuenta = new ArrayList<Movimiento>();
        for (Movimiento movimiento : datos) {
            if (movimiento.getCuentaOrigen().equals(cuenta) || movimiento.getCuentaDestino().equals(cuenta)) {
                movimientosCuenta.add(movimiento);
            }
        }
        return movimientosCuenta;
    }


    @Override
    public void save(Movimiento movimiento) {
        long id = 1L;
        if (!datos.isEmpty()) {
            id = datos.getLast().getId() + 1;
        }
        movimiento.setId(id);
        datos.add(movimiento);
    }
}