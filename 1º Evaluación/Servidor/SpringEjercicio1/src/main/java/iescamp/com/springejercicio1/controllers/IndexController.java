package iescamp.com.springejercicio1.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
public class IndexController {
    @GetMapping("/")

    @ResponseBody

    public String helloWorld() {return "Hola Mundo";}

//    @GetMapping(" /Welcome")
//    @ResponseBody
//    public String welcomeWithParamName(@RequestParam String name) {
//        return "Bienvenido " + name + "!";
//    }


    // Definir un objeto de log
    private static final Logger loggerController =
            LoggerFactory.getLogger(IndexController.class);

    // http://localhost:8888/welcome?name=David
    //@GetMapping("/welcome")
    @RequestMapping(value = "/welcome", method = RequestMethod.GET, produces =
            "application/json")
    @ResponseBody
    public String welcomeWithParamName(@RequestParam(required = false, defaultValue = "")
                                       String name) {
        if (name.isBlank()) {
            loggerController.warn("Saludo sin parametro");
            return "Bienvenido a programar en SpringBoot!";
        } else {
            loggerController.warn("Ha saludado a " + name);
            return "Bienvenido " + name + "!";
        }
    }

    // http://localhost:8888/welcomeParams
    @PostMapping("/welcomeParams")
    @ResponseBody
    public String welcomeParams(@RequestParam(required = false, defaultValue = "") String name,
    @RequestParam(required = false, defaultValue = "0") int age) {
        loggerController.warn("Ha saludado a " + name + " con edad " + age);
        return "Bienvenido " + name + " con edad " + age;
    }

    @PostMapping("/welcomeMultipleParams")
    @ResponseBody
    public String welcomeMultipleParams(@RequestParam(required = false) String[]
                                                parametros) {
        String msg = "";
        int i = 0;
        if (parametros == null) {
            msg = "El array está vacio.";
        }else {
            for(String param : parametros) {
                msg = msg + "parametro[" + i + "]" + param + "\n";
                i++;
            }
        }
        return msg;
    }

}
