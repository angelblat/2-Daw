package com.example.demo5.services;

import com.example.demo5.models.dto.ClienteDTO;
import com.example.demo5.repositories.dao.ClienteRepository;
import com.example.demo5.repositories.entity.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> findAll() {
        List<ClienteDTO> listaClientesDTO = new ArrayList<ClienteDTO>();
        List <Cliente> listaClientes = clienteRepository.findAll();
        for (Cliente cliente : listaClientes) {
            ClienteDTO clienteDTO = ClienteDTO.convertToDTO(cliente);
            listaClientesDTO.add(clienteDTO);
        }

        return listaClientesDTO;
    }

    @Override
    public ClienteDTO findById(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente = clienteRepository.findById(cliente);
        if(cliente!=null) {
            clienteDTO = ClienteDTO.convertToDTO(cliente);
            return clienteDTO;
        }else {
            return null;
        }
    }

    @Override
    public void save(ClienteDTO clienteDTO) {
        Cliente cliente = ClienteDTO.convertToEntity(clienteDTO);
        clienteRepository.save(cliente);
    }

    @Override
    public void delete(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        clienteRepository.delete(cliente);
    }
}
















