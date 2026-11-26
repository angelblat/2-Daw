package com.example.demo5.models.dto;

import com.example.demo5.repositories.entity.Cuenta;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.demo5.repositories.entity.Cliente;


@Data
public class ClienteDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String nif;
    private String nombre;
    private String apellidos;
    private String claveSeguridad;
    private String email;
    @ToString.Exclude
    private RecomendacionDTO recomendacionDTO;

    @ToString.Exclude
    private List<CuentaDTO> listaCuentasDTO;   // y en el constructor: new ArrayList

    public static ClienteDTO convertToDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNif(cliente.getNif());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setApellidos(cliente.getApellidos());
        clienteDTO.setClaveSeguridad(cliente.getClaveSeguridad());
        clienteDTO.setEmail(cliente.getEmail());

        clienteDTO.setRecomendacionDTO(RecomendacionDTO.convertToDTO
                (cliente.getRecomendacion(), clienteDTO));

        for (Cuenta cuenta : cliente.getListaCuentas()) {
            CuentaDTO cuentaDTO = CuentaDTO.convertToDTO(cuenta, clienteDTO);
            clienteDTO.getListaCuentasDTO().add(cuentaDTO);
        }
        return clienteDTO;
    }



    public static Cliente convertToEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setNif(clienteDTO.getNif());
        cliente.setApellidos(clienteDTO.getApellidos());
        cliente.setClaveSeguridad(clienteDTO.getClaveSeguridad());
        cliente.setEmail(clienteDTO.getEmail());

        cliente.setRecomendacion(RecomendacionDTO.convertToEntity
                (clienteDTO.getRecomendacionDTO(), cliente));

        for (CuentaDTO cuentaDTO : clienteDTO.getListaCuentasDTO()) {
            Cuenta cuenta = CuentaDTO.convertToEntity(cuentaDTO, cliente);
            cliente.getListaCuentas().add(cuenta);
        }

        return cliente;
    }

    public ClienteDTO() {
        super();
        this.recomendacionDTO = new RecomendacionDTO();
        this.listaCuentasDTO = new ArrayList<CuentaDTO>();
    }
}