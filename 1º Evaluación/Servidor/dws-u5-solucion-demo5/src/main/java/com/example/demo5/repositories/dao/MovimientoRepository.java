package com.example.demo5.repositories.dao;

import com.example.demo5.repositories.entity.Cuenta;
import com.example.demo5.repositories.entity.Movimiento;

import java.util.List;

public interface MovimientoRepository {
    List<Movimiento> findAllByCuenta(Cuenta cuenta);
    void save(Movimiento movimiento);
}
