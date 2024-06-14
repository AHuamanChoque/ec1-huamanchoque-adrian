package pe.edu.idat.ec1_huaman_adrian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.idat.ec1_huaman_adrian.model.Ejercicio3;

import java.time.Month;

@Controller
public class Ejercicio3Controller {

        @GetMapping("/mesEnLetras")
        public String mostrarFormulario() {
            return "Ejercicio3";
        }

        @PostMapping("/mesEnLetras")
        public String procesarNumero(@RequestParam("numero") int numero, Model model) {
            Ejercicio3 ejercicio3 = new Ejercicio3();
            ejercicio3.setNumero(numero);


            if (numero >= 1 && numero <= 12) {

                String nombreMes = Month.of(numero).name();

                nombreMes = nombreMes.substring(0, 1).toUpperCase() + nombreMes.substring(1).toLowerCase();


                model.addAttribute("nombreMes", nombreMes);
            } else {

                model.addAttribute("error", "El número ingresado no corresponde a un mes válido.");
            }

            return "ejercicio3Resultado";
        }
    }

