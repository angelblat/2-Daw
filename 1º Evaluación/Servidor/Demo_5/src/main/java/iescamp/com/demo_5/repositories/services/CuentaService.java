package iescamp.com.demo_5.repositories.services;

import iescamp.com.demo_5.models.dto.CuentaDTO;

import java.util.List;

public interface CuentaService {

    List<CuentaDTO> findAll();
    CuentaDTO findById(CuentaDTO cuentaDTO);
    void save(CuentaDTO cuentaDTO);
    void delete(CuentaDTO cuentaDTO);
}
