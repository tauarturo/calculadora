package com.example.calculadora.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/calculadora")
public class OperationsController {


    @GetMapping("/suma")
    public double getSuma(@RequestParam("sumando1") double sumando1, @RequestParam("sumando2") double sumando2) {
        return sumando1 + sumando2;
    }

    @GetMapping("/resta")
    public double getResta(@RequestParam("minuendo") double minuendo, @RequestParam("sustraendo") double sustraendo) {
        double resultado = minuendo - sustraendo;
        return resultado;
    }

}
