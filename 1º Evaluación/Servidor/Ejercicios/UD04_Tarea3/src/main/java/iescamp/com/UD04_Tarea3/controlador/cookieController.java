package iescamp.com.UD04_Tarea3.controlador;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class cookieController {

    @GetMapping("/")
    public String pruebaCookies (HttpServletResponse response,
                                 @CookieValue(name = "Contador", required = false) String lecturaCookie,
                                 Model objModelo) {



        if (lecturaCookie == null) {
            Cookie cookie1 = new Cookie("Contador", "0");
            cookie1.setMaxAge(15 * 60);
            response.addCookie(cookie1);

            String respuesta = "Se acaba de crear la cookie con la función contador. 0 visitas por ahora.";
            objModelo.addAttribute("Inicializacion", respuesta);
            return "index";
        } else {
            int contador = Integer.parseInt(lecturaCookie);
            contador++;

            Cookie cookieActualizada = new Cookie("Contador", String.valueOf(contador));
            cookieActualizada.setMaxAge(15 * 60);
            response.addCookie(cookieActualizada);

            objModelo.addAttribute("Inicializacion", "¡Bienvenido de nuevo! Esta es tu visita número: " + contador);
            return "index";
        }


    }
}
