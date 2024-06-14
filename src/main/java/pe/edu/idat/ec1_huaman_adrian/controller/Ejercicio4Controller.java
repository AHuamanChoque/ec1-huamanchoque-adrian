package pe.edu.idat.ec1_huaman_adrian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Ejercicio4Controller {
    @GetMapping("/sumaDigitosFormulario")
    public String mostrarFormulario(Model model) {
        return "Ejercicio4";
    }

    @PostMapping("/sumaDigitos")
    public String procesarNumeros(Model model) {
        int sumaTotal = 0;
        for (int i = 23; i <= 99; i++) {
            int suma = 0;
            int numero = i;
            while (numero != 0) {
                suma += numero % 10;
                numero /= 10;
            }
            sumaTotal += suma;
        }
        model.addAttribute("sumaTotal", sumaTotal);
        return "Ejercicio4Resultado";
    }
}
