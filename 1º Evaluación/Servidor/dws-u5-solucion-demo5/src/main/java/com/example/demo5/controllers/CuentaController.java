package com.example.demo5.controllers;

import java.util.List;

import com.example.demo5.models.dto.CuentaDTO;
import com.example.demo5.services.CuentaService;
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
//import com.example.demo5.models.dto.CuentaDTO;
import com.example.demo5.services.ClienteService;

@Controller
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes/{idCliente}/cuentas")
    public ModelAndView findAllByCliente(@PathVariable Long idCliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(idCliente);
        clienteDTO = clienteService.findById(clienteDTO);
        List<CuentaDTO> listaCuentasDTO = cuentaService.findAllByCliente(clienteDTO);
        ModelAndView mav = new ModelAndView("cuentas");
        mav.addObject("clienteDTO", clienteDTO);
        mav.addObject("listaCuentasDTO", listaCuentasDTO);
        return mav;
    }

    @GetMapping("/clientes/{idCliente}/cuentas/add")
    public ModelAndView add(@PathVariable Long idCliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(idCliente);
        clienteDTO = clienteService.findById(clienteDTO);
        ModelAndView mav = new ModelAndView("cuentaform");
        mav.addObject("clienteDTO", clienteDTO);
        mav.addObject("cuentaDTO", new CuentaDTO());
        mav.addObject("add", true);
        return mav;
    }

    @PostMapping("/clientes/{idCliente}/cuentas/save")
    public ModelAndView save(@PathVariable("idCliente") Long idCliente,
                             @ModelAttribute("cuentaDTO") CuentaDTO cuentaDTO) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(idCliente);
        cuentaDTO.setClienteDTO(clienteDTO);
        cuentaService.save(cuentaDTO);
        return new ModelAndView("redirect:/clientes/" + idCliente + "/cuentas");
    }

    @GetMapping("/clientes/{idCliente}/cuentas/update/{idCuenta}")
    public ModelAndView update(@PathVariable("idCliente") Long idCliente,
                               @PathVariable("idCuenta") Long idCuenta) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(idCliente);
        clienteDTO = clienteService.findById(clienteDTO);
        CuentaDTO cuentaDTO = new CuentaDTO();
        cuentaDTO.setId(idCuenta);
        cuentaDTO.setClienteDTO(clienteDTO);
        cuentaDTO = cuentaService.findById(cuentaDTO);
        ModelAndView mav = new ModelAndView("cuentaform");
        mav.addObject("clienteDTO", clienteDTO);
        mav.addObject("cuentaDTO", cuentaDTO);
        mav.addObject("add", false);
        return mav;
    }

    @GetMapping("/clientes/{idCliente}/cuentas/delete/{idCuenta}")
    public ModelAndView delete(@PathVariable("idCliente") Long idCliente,
                               @PathVariable("idCuenta") Long idCuenta) {
        CuentaDTO cuentaDTO = new CuentaDTO();
        cuentaDTO.setId(idCuenta);
        cuentaService.delete(cuentaDTO);
        return new ModelAndView("redirect:/clientes/" + idCliente + "/cuentas");
    }
}