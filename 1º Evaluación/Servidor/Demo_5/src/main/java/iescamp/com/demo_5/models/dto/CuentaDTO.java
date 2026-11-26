package iescamp.com.demo_5.models.dto;

import iescamp.com.demo_5.repositories.entities.Cliente;
import iescamp.com.demo_5.repositories.entities.Cuenta;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
public class CuentaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String banco, sucursal, numeroCuenta, dc;
    private double saldoCuenta;
    private Cliente cliente;
    @ToString.Exclude
    private ClienteDTO clienteDTO;

    public CuentaDTO() {
        super();
        this.clienteDTO = new ClienteDTO();
    }

    public static CuentaDTO convertToDTO(Cuenta cuenta) {
        CuentaDTO cuentaDTO = new CuentaDTO();
        cuentaDTO.setId(cuenta.getId());
        cuentaDTO.setDc(cuenta.getDc());
        cuentaDTO.setBanco(cuenta.getBanco());
        cuentaDTO.setSucursal(cuenta.getSucursal());
        cuentaDTO.setNumeroCuenta(cuenta.getNumeroCuenta());
        cuentaDTO.setSaldoCuenta(cuenta.getSaldoCuenta());
        cuentaDTO.setClienteDTO(ClienteDTO.convertToDTO(cuenta.getCliente()));

        return cuentaDTO;
    }

    public static Cuenta convertToEntity(CuentaDTO cuentaDTO) {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(cuentaDTO.getId());
        cuenta.setDc(cuentaDTO.getDc());
        cuenta.setBanco(cuentaDTO.getBanco());
        cuenta.setSucursal(cuentaDTO.getSucursal());
        cuenta.setNumeroCuenta(cuentaDTO.getNumeroCuenta());
        cuenta.setSaldoCuenta(cuentaDTO.getSaldoCuenta());
        cuenta.setCliente(ClienteDTO.convertToEntity(cuentaDTO.getClienteDTO()));
        return cuenta;
    }
}
