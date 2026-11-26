package com.example.demo5.controllers;

import com.example.demo5.models.dto.ClienteDTO;
import com.example.demo5.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public ModelAndView findAll() {
        ModelAndView mav = new ModelAndView("clientes");
        List<ClienteDTO> listaClientesDTO = clienteService.findAll();
        mav.addObject("listaClientesDTO", listaClientesDTO);
        return mav;
    }

    @GetMapping("/clientes/{idCliente}")
    public ModelAndView findById(@PathVariable Long idCliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(idCliente);
        clienteDTO = clienteService.findById(clienteDTO);
        ModelAndView mav = new ModelAndView("clienteshow");
        mav.addObject("clienteDTO", clienteDTO);

        return mav;
    }

    @GetMapping("/clientes/add")
    public ModelAndView add() {
        ModelAndView mav = new ModelAndView("clienteform");
        mav.addObject("clienteDTO", new ClienteDTO()); //Añadimos un ClienteDTO vacío

        return mav;
    }

    @PostMapping("/clientes/save")
    public ModelAndView save(@ModelAttribute("clienteDTO") ClienteDTO clienteDTO) {
        clienteService.save(clienteDTO);

        return new ModelAndView("redirect:/clientes");
    }

    @GetMapping("/clientes/update/{idCliente}")
    public ModelAndView update(@PathVariable("idCliente") Long idCliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(idCliente);
        clienteDTO = clienteService.findById(clienteDTO);
        ModelAndView mav = new ModelAndView("clienteform");
        mav.addObject("clienteDTO", clienteDTO);

        return mav;
    }

    @GetMapping("/clientes/delete/{idCliente}")
    public ModelAndView delete(@PathVariable("idCliente") Long idCliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(idCliente);
        clienteService.delete(clienteDTO);

        return new ModelAndView("redirect:/clientes");
    }

}

