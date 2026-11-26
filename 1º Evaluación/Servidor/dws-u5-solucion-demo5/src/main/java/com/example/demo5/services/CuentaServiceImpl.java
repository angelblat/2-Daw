package com.example.demo5.services;

import java.util.ArrayList;
import java.util.List;

import com.example.demo5.repositories.dao.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo5.models.dto.ClienteDTO;
import com.example.demo5.models.dto.CuentaDTO;
import com.example.demo5.repositories.dao.CuentaRepository;
import com.example.demo5.repositories.entity.Cliente;
import com.example.demo5.repositories.entity.Cuenta;

@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public List<CuentaDTO> findAllByCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        List<CuentaDTO> listaCuentasDTO = new ArrayList<CuentaDTO>();
        List<Cuenta> listaCuentas = cuentaRepository.findAllByCliente(cliente);
        for (Cuenta cuenta : listaCuentas){
            CuentaDTO cuentaDTO = CuentaDTO.convertToDTO(cuenta, clienteDTO);
            listaCuentasDTO.add(cuentaDTO);
        }

        return listaCuentasDTO;
    }

    @Override
    public CuentaDTO findById(CuentaDTO cuentaDTO) {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(cuentaDTO.getId());
        cuenta = cuentaRepository.findById(cuenta);
        return CuentaDTO.convertToDTO(cuenta, cuentaDTO.getClienteDTO());
    }

    @Override
    public void save(CuentaDTO cuentaDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(cuentaDTO.getClienteDTO().getId());
        Cuenta cuenta = CuentaDTO.convertToEntity(cuentaDTO, cliente);
        cuentaRepository.save(cuenta);
    }

    @Override
    public void delete(CuentaDTO cuentaDTO) {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(cuentaDTO.getId());
        cuentaRepository.delete(cuenta);
    }
}

