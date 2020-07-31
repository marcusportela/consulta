package com.programem.cunsulta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InicioController {
    @GetMapping("/")
    public String inicio(){
        return "inicio";
    }

    @PostMapping("/")
    public String inicioPost(){
        return "inicio";
    }
}