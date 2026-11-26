package com.example.demo5.services;

import com.example.demo5.models.dto.ClienteDTO;
import com.example.demo5.models.dto.CuentaDTO;

import java.util.List;

public interface CuentaService {

    List<CuentaDTO> findAllByCliente(ClienteDTO clienteDTO);
    CuentaDTO findById(CuentaDTO cuentaDTO);
    void save(CuentaDTO cuentaDTO);
    void delete(CuentaDTO cuentaDTO);
    }
