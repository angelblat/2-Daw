package com.example.demo5.models.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import com.example.demo5.repositories.entity.Recomendacion;
import com.example.demo5.repositories.entity.Cliente;

@Data
public class RecomendacionDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String observaciones;

    @ToString.Exclude
    private ClienteDTO clienteDTO;

    public static RecomendacionDTO convertToDTO(Recomendacion recomendacion,
                                                ClienteDTO clienteDTO){
        RecomendacionDTO recomendacionDTO = new RecomendacionDTO();
        recomendacionDTO.setId(recomendacion.getId());
        recomendacionDTO.setObservaciones(recomendacion.getObservaciones());
        recomendacionDTO.setClienteDTO(clienteDTO);

        return recomendacionDTO;
    }

    public static Recomendacion convertToEntity(RecomendacionDTO recomendacionDTO,
                                                Cliente cliente){
        Recomendacion recomendacion = new Recomendacion();
        recomendacion.setId(recomendacionDTO.getId());
        recomendacion.setObservaciones(recomendacionDTO.getObservaciones());
        recomendacion.setCliente(cliente);

        return recomendacion;
    }
}

