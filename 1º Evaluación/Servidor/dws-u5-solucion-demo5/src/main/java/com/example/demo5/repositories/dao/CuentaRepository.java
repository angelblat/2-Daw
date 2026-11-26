package com.example.demo5.repositories.dao;

import java.util.List;

import com.example.demo5.repositories.entity.Cliente;
import com.example.demo5.repositories.entity.Cuenta;

public interface CuentaRepository {
    List<Cuenta> findAllByCliente(Cliente cliente);
    Cuenta findById(Cuenta cuenta);
    void save(Cuenta cuenta);
    void delete(Cuenta cuenta);
}
