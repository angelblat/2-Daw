package com.example.demo5.repositories.dao;

import com.example.demo5.repositories.entity.Cliente;

import java.util.List;

public interface ClienteRepository {
    List<Cliente> findAll();
    Cliente findById(Cliente cliente);
    void save(Cliente cliente);
    void delete(Cliente cliente);
}
