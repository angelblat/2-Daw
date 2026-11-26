package iescamp.com.demo_5.models.dto;

import java.io.Serializable;

import iescamp.com.demo_5.repositories.entities.Cliente;
import iescamp.com.demo_5.repositories.entities.Recomendacion;
import lombok.Data;
import lombok.ToString;

@Data
public class RecomendacionDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private Long id;
    private String observaciones;
    @ToString.Exclude
    private ClienteDTO clienteDTO;

    //Convierte una entidad a un objeto DTO
    public static RecomendacionDTO convertToDTO(Recomendacion recomendacion, ClienteDTO
            clienteDTO) {
        if (recomendacion == null) {
            return null;
        }
        // Creamos el objeto recomendacionDTO y asignamos los valores basicos
        RecomendacionDTO recomendacionDTO = new RecomendacionDTO();
        recomendacionDTO.setId(recomendacion.getId());
        recomendacionDTO.setObservaciones(recomendacion.getObservaciones());
        recomendacionDTO.setClienteDTO(clienteDTO);
        // Retorna el DTO
        return recomendacionDTO;
    }

    // Convierte un objeto DTO a una entidad
    public static Recomendacion convertToEntity(RecomendacionDTO recomendacionDTO,
                                                Cliente cliente) {
        if (recomendacionDTO == null) {
            return null;
        }

        // Creamos la entidad Recomendacion y le asignamos los valores
        Recomendacion recomendacion = new Recomendacion();
        recomendacion.setId(recomendacionDTO.getId());
        recomendacion.setObservaciones(recomendacionDTO.getObservaciones());
        recomendacion.setCliente(cliente);

        // Retorna el entity
        return recomendacion;
    }
}