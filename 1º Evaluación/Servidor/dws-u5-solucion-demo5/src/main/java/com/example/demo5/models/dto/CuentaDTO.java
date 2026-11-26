package com.example.demo5.models.dto;

import com.example.demo5.repositories.entity.Cliente;
import com.example.demo5.repositories.entity.Cuenta;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Data
public class CuentaDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String banco;
    private String sucursal;
    private String dc;
    private String numeroCuenta;
    private Double saldoActual;
    @ToString.Exclude
    private ClienteDTO clienteDTO;

    public static CuentaDTO convertToDTO(Cuenta cuenta,
                                         ClienteDTO clienteDTO) {
        CuentaDTO cuentaDTO = new CuentaDTO();
        cuentaDTO.setId(cuenta.getId());
        cuentaDTO.setBanco(cuenta.getBanco());
        cuentaDTO.setSucursal(cuenta.getSucursal());
        cuentaDTO.setDc(cuenta.getDc());
        cuentaDTO.setNumeroCuenta(cuenta.getNumeroCuenta());
        cuentaDTO.setSaldoActual(cuenta.getSaldoActual());
        cuentaDTO.setClienteDTO(clienteDTO);

        return cuentaDTO;
    }

    public static Cuenta convertToEntity(CuentaDTO cuentaDTO,
                                         Cliente cliente) {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(cuentaDTO.getId());
        cuenta.setBanco(cuentaDTO.getBanco());
        cuenta.setSucursal(cuentaDTO.getSucursal());
        cuenta.setDc(cuentaDTO.getDc());
        cuenta.setNumeroCuenta(cuentaDTO.getNumeroCuenta());
        cuenta.setSaldoActual(cuentaDTO.getSaldoActual());
        cuenta.setCliente(cliente);

        return cuenta;
    }
}


