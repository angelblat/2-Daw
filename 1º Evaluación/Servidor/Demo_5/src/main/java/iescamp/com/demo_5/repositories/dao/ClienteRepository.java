package iescamp.com.demo_5.repositories.dao;

import iescamp.com.demo_5.models.dto.ClienteDTO;
import iescamp.com.demo_5.repositories.entities.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository {
    List<Cliente> findAll();
    Cliente findById(Cliente cliente);
    void save(Cliente cliente);
    void delete(Cliente cliente);
}
