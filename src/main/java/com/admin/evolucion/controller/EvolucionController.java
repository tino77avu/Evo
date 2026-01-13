package com.admin.evolucion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EvolucionController {

    @GetMapping("/")
    public String index() {
        return "evolucion4";
    }

    @GetMapping("/el-cambio")
    public String elCambio() {
        return "el-cambio";
    }

    @GetMapping("/problema")
    public String problema() {
        return "problema";
    }

    @GetMapping("/solucion")
    public String solucion() {
        return "solucion";
    }

    @GetMapping("/como-funciona")
    public String comoFunciona() {
        return "como-funciona";
    }

    @GetMapping("/lo-que-logras")
    public String loQueLogras() {
        return "lo-que-logras";
    }

    @GetMapping("/beneficios")
    public String beneficios() {
        return "beneficios";
    }

    @GetMapping("/ejemplo")
    public String ejemplo() {
        return "ejemplo";
    }

    @GetMapping("/por-que-evo")
    public String porQueEvo() {
        return "por-que-evo";
    }

    @GetMapping("/para-quien")
    public String paraQuien() {
        return "para-quien";
    }

    @GetMapping("/diferencias")
    public String diferencias() {
        return "diferencias";
    }

    @GetMapping("/seguridad")
    public String seguridad() {
        return "seguridad";
    }

    @GetMapping("/faq")
    public String faq() {
        return "faq";
    }

    @GetMapping("/contacto")
    public String contacto() {
        return "contacto";
    }

    @GetMapping("/politica-privacidad")
    public String politicaPrivacidad() {
        return "politica-privacidad";
    }

    @GetMapping("/terminos-condiciones")
    public String terminosCondiciones() {
        return "terminos-condiciones";
    }

    @GetMapping("/politica-cookies")
    public String politicaCookies() {
        return "politica-cookies";
    }

    @GetMapping("/planes")
    public String planes() {
        return "planes";
    }

    @PostMapping("/contacto")
    public String enviarConsulta(
            @RequestParam String nombre,
            @RequestParam String email,
            @RequestParam(required = false) String telefono,
            @RequestParam String consulta,
            RedirectAttributes redirectAttributes) {
        
        // Aquí puedes agregar la lógica para procesar y guardar la consulta
        // Por ejemplo, enviar un email, guardar en base de datos, etc.
        
        // Por ahora, solo redirigimos con un mensaje de éxito
        redirectAttributes.addFlashAttribute("mensaje", "¡Gracias por contactarnos! Te responderemos pronto.");
        return "redirect:/contacto?exito=true";
    }
}
