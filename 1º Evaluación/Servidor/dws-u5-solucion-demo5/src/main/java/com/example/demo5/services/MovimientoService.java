package com.example.demo5.services;

import com.example.demo5.models.dto.CuentaDTO;
import com.example.demo5.models.dto.MovimientoDTO;

import java.util.List;

public interface MovimientoService {
    List<MovimientoDTO> findAllByCuenta(CuentaDTO cuentaDTO);
    String transferir(MovimientoDTO movimientoDTO);
}
