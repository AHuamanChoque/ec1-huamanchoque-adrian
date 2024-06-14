package pe.edu.idat.ec1_huaman_adrian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.idat.ec1_huaman_adrian.model.Ejercicio2;

@Controller
public class Ejercicio2Controller {

    @GetMapping("/operacion")
    public String mostrarFormulario(Model model) {
        model.addAttribute("ejercicio2", new Ejercicio2());
        return "Ejercicio2"; // Nombre del archivo HTML del formulario
    }

    @PostMapping("/operacion")
    public String procesarOperacion(@RequestParam("numero1") int numero1,
                                    @RequestParam("numero2") int numero2,
                                    Model model) {
        Ejercicio2 ejercicio = new Ejercicio2();
        ejercicio.setNumero1(numero1);
        ejercicio.setNumero2(numero2);

        if (numero1 == numero2) {
            ejercicio.setResultado(numero1 * numero2);
        } else if (numero1 > numero2) {
            ejercicio.setResultado(numero1 - numero2);
        } else {
            ejercicio.setResultado(numero1 + numero2);
        }

        model.addAttribute("ejercicio2", ejercicio);
        return "resultadoOperacion"; // Nombre del archivo HTML del resultado
    }
}



