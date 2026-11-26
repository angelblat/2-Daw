package com.example.demo5.models.dto;

import com.example.demo5.repositories.entity.Cuenta;
import com.example.demo5.repositories.entity.Movimiento;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
public class MovimientoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String tipo;
    private LocalDate fechaOperacion;
    private String descripcion;
    private Double importe;
    @ToString.Exclude
    private CuentaDTO cuentaOrigenDTO;
    @ToString.Exclude
    private CuentaDTO cuentaDestinoDTO;

    public static MovimientoDTO convertToDTO(Movimiento movimiento, CuentaDTO cuentaOrigenDTO,
                                             CuentaDTO cuentaDestinoDTO) {
        MovimientoDTO movimientoDTO = new MovimientoDTO();
        movimientoDTO.setId(movimiento.getId());
        movimientoDTO.setTipo(movimiento.getTipo());
        movimientoDTO.setFechaOperacion(movimiento.getFechaOperacion());
        movimientoDTO.setDescripcion(movimiento.getDescripcion());
        movimientoDTO.setImporte(movimiento.getImporte());
        movimientoDTO.setCuentaOrigenDTO(cuentaOrigenDTO);
        movimientoDTO.setCuentaDestinoDTO(cuentaDestinoDTO);
        return movimientoDTO;
    }

    public static Movimiento convertToEntity(MovimientoDTO movimientoDTO, Cuenta cuentaOrigen,
                                             Cuenta cuentaDestino) {
        Movimiento movimiento = new Movimiento();
        movimiento.setId(movimientoDTO.getId());
        movimiento.setTipo(movimientoDTO.getTipo());
        movimiento.setFechaOperacion(movimientoDTO.getFechaOperacion());
        movimiento.setDescripcion(movimientoDTO.getDescripcion());
        movimiento.setImporte(movimientoDTO.getImporte());
        movimiento.setCuentaOrigen(cuentaOrigen);
        movimiento.setCuentaDestino(cuentaDestino);
        return movimiento;
    }

    public MovimientoDTO() {
        super();
        this.cuentaOrigenDTO = new CuentaDTO();
        this.cuentaDestinoDTO = new CuentaDTO();
    }
}
