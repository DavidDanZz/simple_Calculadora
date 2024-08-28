package com.example.simplescalculadora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculadoraController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/calcular")
    public String calcular(@RequestParam("num1") double num1,
                           @RequestParam("num2") double num2,
                           @RequestParam("operacao") String operacao,
                           Model model) {
        double resultado = 0;

        switch (operacao) {
            case "somar":
                resultado = num1 + num2;
                break;
            case "subtrair":
                resultado = num1 - num2;
                break;
            case "multiplicar":
                resultado = num1 * num2;
                break;
            case "dividir":
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    model.addAttribute("erro", "Não é possível dividir por zero.");
                    return "index";
                }
                break;
        }

        model.addAttribute("resultado", (int) resultado);
        return "index";
    }
}
