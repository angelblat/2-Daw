package iescamp.com.demo_5.controllers;

import iescamp.com.demo_5.models.dto.ClienteDTO;
import iescamp.com.demo_5.repositories.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

import static iescamp.com.demo_5.controllers.IndexController.*;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Listar los clientes
    @GetMapping("/clientes")
    public ModelAndView findAll() {


        ModelAndView mav = new ModelAndView("clientes");
        List<ClienteDTO> listaClientesDTO =  clienteService.findAll();
        mav.addObject("listaClientesDTO", listaClientesDTO);

        return mav;
    }

    // Listar los clientes
    @GetMapping("/clientes/{idCliente}")
    public ModelAndView findById(@PathVariable("idCliente") Long id) {

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(id);
        clienteDTO = clienteService.findById(clienteDTO);

        ModelAndView mav = new ModelAndView("clienteShow");
        mav.addObject("clienteDTO", clienteDTO);

        return mav;
    }

    // Alta de clientes
    @GetMapping("/clientes/add")
    public ModelAndView add() {

        ModelAndView mav = new ModelAndView("clienteform");
        mav.addObject("clienteDTO", new ClienteDTO());
        mav.addObject("add", true);


        return mav;
    }

    // Guardar los datos de un nuevo cliente

    @PostMapping("/clientes/save")
    public ModelAndView save(@ModelAttribute ClienteDTO clienteDTO){

        clienteService.save(clienteDTO);
        ModelAndView mav = new ModelAndView("redirect:/clientes");
        return mav;
    }

    // Operacion "actualizar cliente"

    @GetMapping("/clientes/update/{idCliente}")
    public ModelAndView update(@PathVariable Long idCliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(idCliente);
        clienteDTO = clienteService.findById(clienteDTO);
        ModelAndView mav = new ModelAndView("form_cliente");
        mav.addObject("cliente", clienteDTO);
        mav.addObject("add", false);

        return mav;
    }

    // Operacion "Borrar cliente"

    @GetMapping("clientes/delete/{idCliente}")
    public ModelAndView delete (@PathVariable Long idCliente) {

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(idCliente);
        clienteService.delete(clienteDTO);
        ModelAndView mav = new ModelAndView("redirect:/clientes");

        return mav;
    }

}
