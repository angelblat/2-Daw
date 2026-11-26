package iescamp.com.UD04_Tarea1.controlador;

import iescamp.com.UD04_Tarea1.entities.Operacion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CapturaDatosController {

    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        model.addAttribute("operacion", new Operacion());
        return "formulario1";
    }

    @PostMapping("/calcular")
    public String procesarDatos(@ModelAttribute("operacion") Operacion operacion, Model model) {
        String mensaje = "";

        try {
            double op1 = Double.parseDouble(operacion.getOperando1());
            double op2 = Double.parseDouble(operacion.getOperando2());
            double resultado = 0;

            switch (operacion.getOperador()) {
                case "+":
                    resultado = op1 + op2;
                    break;
                case "-":
                    resultado = op1 - op2;
                    break;
                case "*":
                    resultado = op1 * op2;
                    break;
                case "/":
                    if (op2 != 0) {
                        resultado = op1 / op2;
                    } else {
                        mensaje = "Error: División por cero.";
                    }
                    break;
                default:
                    mensaje = "Operador no válido.";
            }

            if (mensaje.isEmpty()) {
                mensaje = "Resultado: " + resultado;
            }

        } catch (NumberFormatException e) {
            mensaje = "Error: Entrada no válida.";
        }

        model.addAttribute("mensaje", mensaje);

        return "formulario2";
    }
}
