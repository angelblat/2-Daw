package com.example.demo5.repositories.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo5.repositories.entity.Cliente;
import com.example.demo5.repositories.entity.Cuenta;
@Repository
public class CuentaRepositoryImpl implements CuentaRepository {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cuenta> findAllByCliente(Cliente cliente) {
        cliente = clienteRepository.findById(cliente);
        return cliente.getListaCuentas();
    }

    @Override
    public Cuenta findById(Cuenta cuenta) {
        for (Cliente cliente : clienteRepository.findAll()) {
            int posicion = cliente.getListaCuentas().indexOf(cuenta);
            if (posicion != -1) {
                return cliente.getListaCuentas().get(posicion);
            }
        }
        return null;
    }

    @Override
    public void save(Cuenta cuenta) {
        Cliente cliente = clienteRepository.findById(cuenta.getCliente());
        cuenta.setCliente(cliente);

        if (cuenta.getId() != null) {
            // ACTUALIZAR
            int posicion = cliente.getListaCuentas().indexOf(cuenta);
            cliente.getListaCuentas().set(posicion, cuenta);
        } else {
            // INSERTAR: Calcular el ID máximo global + 1
            long id = 1L;
            for (Cliente c : clienteRepository.findAll()) {
                for (Cuenta cu : c.getListaCuentas()) {
                    if (cu.getId() >= id) {
                        id = cu.getId() + 1;
                    }
                }
            }
            cuenta.setId(id);
            cliente.getListaCuentas().add(cuenta);
        }
    }

    @Override
    public void delete(Cuenta cuenta) {
        Cuenta cuentaReal = findById(cuenta);
        if (cuentaReal != null) {
            cuentaReal.getCliente().getListaCuentas().remove(cuentaReal);
        }
    }

}