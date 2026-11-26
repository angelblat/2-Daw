package iescamp.com.demo_5.repositories.dao;

import iescamp.com.demo_5.repositories.entities.Cliente;
import iescamp.com.demo_5.repositories.entities.Cuenta;

import java.util.List;

public interface CuentaRepository {
    List<Cuenta> findAll();
    Cuenta findById(Cuenta cuenta);
    void save(Cuenta cuenta);
    void delete(Cuenta cuenta);
}
