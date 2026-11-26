package iescamp.com.demo_5.controllers;

import iescamp.com.demo_5.models.dto.ClienteDTO;
import iescamp.com.demo_5.repositories.entities.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Value("${aplicacion.nombre}")
    private String nombreAplicacion;

    @Value("${asignatura}")
    private String nombreAsignatura;

    @GetMapping("/")
    public ModelAndView index() {
        log.info("IndexController - index: Mostramos la pagina inicial");

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("titulo", nombreAplicacion);
        mav.addObject("nombreAsignatura", nombreAsignatura);

        return mav;
    }

    /*
    @GetMapping("/")

    public ModelAndView add() {
        log.info("IndexController - index: Mostramos la pagina inicial");

        ModelAndView mav = new ModelAndView("form_cliente");
        mav.addObject("cliente", new ClienteDTO());

        return mav;
    }

     */

}
