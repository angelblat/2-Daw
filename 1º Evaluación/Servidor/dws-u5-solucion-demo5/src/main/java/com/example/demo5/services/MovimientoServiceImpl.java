package com.example.demo5.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo5.models.dto.CuentaDTO;
import com.example.demo5.models.dto.MovimientoDTO;
import com.example.demo5.repositories.dao.CuentaRepository;
import com.example.demo5.repositories.dao.MovimientoRepository;
import com.example.demo5.repositories.entity.Cuenta;
import com.example.demo5.repositories.entity.Movimiento;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public List<MovimientoDTO> findAllByCuenta(CuentaDTO cuentaDTO) {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(cuentaDTO.getId());
        List<MovimientoDTO> listaMovimientosDTO = new ArrayList<MovimientoDTO>();
        for (Movimiento movimiento : movimientoRepository.findAllByCuenta(cuenta)) {
            Cuenta origen = cuentaRepository.findById(movimiento.getCuentaOrigen()); //cuentas del mismo cliente
            Cuenta destino = cuentaRepository.findById(movimiento.getCuentaDestino()); //cuentas del mismo cliente
            CuentaDTO origenDTO = CuentaDTO.convertToDTO(origen, cuentaDTO.getClienteDTO());
            CuentaDTO destinoDTO = CuentaDTO.convertToDTO(destino, cuentaDTO.getClienteDTO());
            listaMovimientosDTO.add(MovimientoDTO.convertToDTO(movimiento, origenDTO, destinoDTO));
        }

        return listaMovimientosDTO;
    }

    @Override
    public String transferir(MovimientoDTO movimientoDTO) {
        Long idOrigen = movimientoDTO.getCuentaOrigenDTO().getId();
        Long idDestino = movimientoDTO.getCuentaDestinoDTO().getId();
        Double importe = movimientoDTO.getImporte();

        if (idOrigen == null || idDestino == null) {
            return "Indique las cuentas de origen y destino de la transferencia";
        }
        if (idOrigen.equals(idDestino)) {
            return "Las cuentas de la transferencia a realizar deben ser distintas";
        }
        if (importe == null || importe <= 0) {
            return "Indique un importe de transferencia correcto";
        }

        Cuenta origen = new Cuenta();
        origen.setId(idOrigen);
        origen = cuentaRepository.findById(origen);
        Cuenta destino = new Cuenta();
        destino.setId(idDestino);
        destino = cuentaRepository.findById(destino);

        if (!origen.getCliente().equals(destino.getCliente())) {
            return "Las transferencias se permiten entre cuentas de un mismo cliente";
        }
        if (origen.getSaldoActual() < importe) {
            return "El saldo de la cuenta de origen es insuficiente para realizar la transferencia";
        }

        origen.setSaldoActual(origen.getSaldoActual() - importe);
        destino.setSaldoActual(destino.getSaldoActual() + importe);
        cuentaRepository.save(origen);
        cuentaRepository.save(destino);
        movimientoDTO.setTipo("Transferencia");
        movimientoDTO.setFechaOperacion(LocalDate.now());
        Movimiento movimiento = MovimientoDTO.convertToEntity(movimientoDTO, origen, destino);
        movimientoRepository.save(movimiento);
        return null;
    }
}