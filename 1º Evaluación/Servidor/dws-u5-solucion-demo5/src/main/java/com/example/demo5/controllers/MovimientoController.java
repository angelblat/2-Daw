package com.example.demo5.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo5.models.dto.ClienteDTO;
import com.example.demo5.models.dto.CuentaDTO;
import com.example.demo5.models.dto.MovimientoDTO;
import com.example.demo5.services.ClienteService;
import com.example.demo5.services.CuentaService;
import com.example.demo5.services.MovimientoService;

@Controller
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes/{idCliente}/cuentas/{idCuenta}/movimientos")
    public ModelAndView findAllByCuenta(@PathVariable("idCliente") Long idCliente,
                                        @PathVariable("idCuenta") Long idCuenta) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(idCliente);
        clienteDTO = clienteService.findById(clienteDTO);
        CuentaDTO cuentaDTO = new CuentaDTO();
        cuentaDTO.setId(idCuenta);
        cuentaDTO.setClienteDTO(clienteDTO);
        cuentaDTO = cuentaService.findById(cuentaDTO);
        ModelAndView mav = new ModelAndView("movimientos");
        mav.addObject("clienteDTO", clienteDTO);
        mav.addObject("cuentaDTO", cuentaDTO);
        mav.addObject("listaMovimientosDTO", movimientoService.findAllByCuenta(cuentaDTO));

        return mav;
    }

    @GetMapping("/clientes/{idCliente}/cuentas/transferencia")
    public ModelAndView transferencia(@PathVariable("idCliente") Long idCliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(idCliente);
        clienteDTO = clienteService.findById(clienteDTO);
        ModelAndView mav = new ModelAndView("transferenciaform");
        mav.addObject("clienteDTO", clienteDTO);
        mav.addObject("listaCuentasDTO", cuentaService.findAllByCliente(clienteDTO));
        mav.addObject("movimientoDTO", new MovimientoDTO());
        return mav;
    }

    @PostMapping("/clientes/{idCliente}/cuentas/transferencia/save")
    public ModelAndView save(@PathVariable("idCliente") Long idCliente,
                             @ModelAttribute("movimientoDTO") MovimientoDTO movimientoDTO) {
        String errorMessage = movimientoService.transferir(movimientoDTO);
        if (errorMessage != null) {
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setId(idCliente);
            clienteDTO = clienteService.findById(clienteDTO);
            ModelAndView mav = new ModelAndView("transferenciaform");
            mav.addObject("clienteDTO", clienteDTO);
            mav.addObject("listaCuentasDTO", cuentaService.findAllByCliente(clienteDTO));
            mav.addObject("errorMessage", errorMessage);

            return mav;
        }

        return new ModelAndView("redirect:/clientes/" + idCliente + "/cuentas");
    }
}