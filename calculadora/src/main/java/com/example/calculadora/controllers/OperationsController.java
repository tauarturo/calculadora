package com.example.calculadora.controllers;


import io.corp.calculator.TracerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @ApiOperation("Suma de Operaciones")
    public String getSuma(@RequestParam("sumando1") @ApiParam(example = "3.2", required = true) String sumando1,
                          @RequestParam("sumando2") @ApiParam(example = "2.8", required = true) String sumando2) {
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
    @ApiOperation("Resta de Operaciones")
    public String getResta(@RequestParam("minuendo") @ApiParam(example = "3.2", required = true)
                            String minuendo,
                           @RequestParam("sustraendo") @ApiParam(example = "2.1", required = true) String sustraendo) {
            String resultado;
            try{
            resultado=String.valueOf(Double.parseDouble(minuendo) - Double.parseDouble(sustraendo));
            }catch(NumberFormatException e) {
        resultado = ERROR;
    }
        tracerImpl.trace(resultado);
        return resultado;
}

}
