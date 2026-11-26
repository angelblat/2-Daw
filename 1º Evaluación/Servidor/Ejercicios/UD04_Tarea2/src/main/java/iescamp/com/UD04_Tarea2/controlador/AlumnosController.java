package iescamp.com.UD04_Tarea2.controlador;


import iescamp.com.UD04_Tarea2.entities.Alumno;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class AlumnosController {

    private ArrayList<Alumno> listaAlumnos = new ArrayList<>();

    @PostConstruct
    public void init(){
        Alumno alumno1 = new Alumno("Carlos", "García", "Martínez", "12345678A");
        Alumno alumno2 = new Alumno("Lucía", "Fernández", "Gómez", "87654321B");
        Alumno alumno3 = new Alumno("Alejandro", "Rodríguez", "López", "45678912C");

        listaAlumnos.add(alumno1);
        listaAlumnos.add(alumno2);
        listaAlumnos.add(alumno3);
    }

    @GetMapping("/")
    public String mostrarFormulario(){
        return "comprobarDNI";
    }

    @PostMapping("/buscar")
    public String findAlumnoByDni(@RequestParam("dni") String dniBuscar, Model model){
        boolean encontrado = false;
        Alumno alumno = null;

        for (int i = 0; i < listaAlumnos.size(); i++) {
            if (listaAlumnos.get(i).getDni().equalsIgnoreCase(dniBuscar)){
                encontrado= true;
                alumno = listaAlumnos.get(i);
            }
        }

        if (encontrado){
            model.addAttribute("alumnoEncontrado", alumno);
            return "muestraDatosAlumno";
        } else {
            model.addAttribute("error", "No existe ningún alumno con" +
                    " ese DNI.");
            return "comprobarDni";
        }
    }
}
