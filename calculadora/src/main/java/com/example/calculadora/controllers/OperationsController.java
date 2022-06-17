package com.example.calculadora.controllers;


import io.corp.calculator.TracerImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/calculadora")
public class OperationsController {

    TracerImpl tracerImpl = new TracerImpl();

    public static String ERROR="Error de calculo de operacion";

    @GetMapping("/suma")
    public String getSuma(@RequestParam("sumando1") String sumando1, @RequestParam("sumando2") String sumando2) {
        String resultado;
        try {
            resultado = String.valueOf(Double.parseDouble(sumando1) + Double.parseDouble(sumando2));
        }catch (NumberFormatException e) {
            resultado= ERROR;
        }
        tracerImpl.trace(resultado);
        return resultado;
    }

    @GetMapping("/resta")
    public String getResta(@RequestParam("minuendo") String minuendo, @RequestParam("sustraendo") String sustraendo) {
        String resultado;
        try {
            resultado = String.valueOf(Double.parseDouble(minuendo) - Double.parseDouble(sustraendo));
        }catch (NumberFormatException e) {
            resultado= ERROR;
        }
        tracerImpl.trace(resultado);
        return resultado;
    }

}
