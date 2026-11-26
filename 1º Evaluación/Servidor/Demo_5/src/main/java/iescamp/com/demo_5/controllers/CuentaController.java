package iescamp.com.demo_5.controllers;

import iescamp.com.demo_5.models.dto.ClienteDTO;
import iescamp.com.demo_5.models.dto.CuentaDTO;
import iescamp.com.demo_5.repositories.services.ClienteService;
import iescamp.com.demo_5.repositories.services.CuentaService;
import iescamp.com.demo_5.repositories.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes/{idCliente}/cuentas")
    public ModelAndView findAllByCliente(@PathVariable("idCliente") Long idCliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(idCliente);
        clienteDTO = clienteService.findById(clienteDTO);

        List<CuentaDTO> todasLasCuentas = cuentaService.findAll();
        List<CuentaDTO> cuentasDelCliente = new ArrayList<>();

        for (CuentaDTO c : todasLasCuentas) {
            if (c.getClienteDTO() != null && c.getClienteDTO().getId().equals(idCliente)) {
                cuentasDelCliente.add(c);
            }
        }

        ModelAndView mav = new ModelAndView("cuentas");
        mav.addObject("clienteDTO", clienteDTO);
        mav.addObject("listaCuentasDTO", cuentasDelCliente);

        return mav;
    }

    @GetMapping("/clientes/{idCliente}/cuentas/add")
    public ModelAndView add(@PathVariable("idCliente") Long idCliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(idCliente);
        clienteDTO = clienteService.findById(clienteDTO);

        CuentaDTO cuentaDTO = new CuentaDTO();
        cuentaDTO.setClienteDTO(clienteDTO);

        ModelAndView mav = new ModelAndView("cuentasForm");
        mav.addObject("cuentaDTO", cuentaDTO);
        mav.addObject("clienteDTO", clienteDTO);
        mav.addObject("add", true);

        return mav;
    }

    @PostMapping("/clientes/{idCliente}/cuentas/save")
    public ModelAndView save(@PathVariable("idCliente") Long idCliente, @ModelAttribute CuentaDTO cuentaDTO) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(idCliente);
        clienteDTO = clienteService.findById(clienteDTO);
        cuentaDTO.setClienteDTO(clienteDTO);

        cuentaService.save(cuentaDTO);

        return new ModelAndView("redirect:/clientes/" + idCliente + "/cuentas");
    }

    @GetMapping("/clientes/{idCliente}/cuentas/update/{idCuenta}")
    public ModelAndView update(@PathVariable("idCliente") Long idCliente, @PathVariable("idCuenta") int idCuenta) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(idCliente);
        clienteDTO = clienteService.findById(clienteDTO);

        CuentaDTO cuentaDTO = new CuentaDTO();
        cuentaDTO.setId((long) idCuenta);
        cuentaDTO = cuentaService.findById(cuentaDTO);

        ModelAndView mav = new ModelAndView("cuentasForm");
        mav.addObject("cuentaDTO", cuentaDTO);
        mav.addObject("clienteDTO", clienteDTO);
        mav.addObject("add", false);

        return mav;
    }

    @GetMapping("/clientes/{idCliente}/cuentas/delete/{idCuenta}")
    public ModelAndView delete(@PathVariable("idCliente") Long idCliente, @PathVariable("idCuenta") int idCuenta) {
        CuentaDTO cuentaDTO = new CuentaDTO();
        cuentaDTO.setId((long) idCuenta);
        cuentaService.delete(cuentaDTO);

        return new ModelAndView("redirect:/clientes/" + idCliente + "/cuentas");
    }
}
