package iescamp.com.demo_5.repositories.services;

import iescamp.com.demo_5.models.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {

    List<ClienteDTO> findAll();
    ClienteDTO findById(ClienteDTO clienteDTO);
    void save(ClienteDTO clienteDTO);
    void delete(ClienteDTO clienteDTO);



}
