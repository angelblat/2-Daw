package iescamp.com.ud04_tarea4.contolador;

import iescamp.com.ud04_tarea4.entities.PedidoPizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PizzaController {

    @GetMapping("/pedidopizza")
    public String mostrarFormulario(Model objModel){

        objModel.addAttribute("pedido", new PedidoPizza());

        return "formularioPizza";
    }

    @PostMapping("/pedidopizza/procesar")
    public String procesarPedido (@ModelAttribute("pedido") PedidoPizza miPedido, Model objModel){

        objModel.addAttribute("pedidoFinal", miPedido);

        return "resumenPedido";
    }
}
