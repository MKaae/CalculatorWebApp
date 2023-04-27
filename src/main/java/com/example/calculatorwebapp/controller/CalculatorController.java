package com.example.calculatorwebapp.controller;

import com.example.calculatorwebapp.service.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    Calculator calculator;

    public CalculatorController(Calculator calculator){
        this.calculator = calculator;
    }

    @GetMapping("/")
    public String index(Model model){
        double result = calculator.finalResult;
        model.addAttribute("result", result);
        return "index";
    }

    @GetMapping("/calcLandingSite")
    public String calculator(){
        return "calcLandingSite";
    }
    @PostMapping("/calcLandingSite")
    public String calcExchange(@RequestParam(value = "first_Currency", defaultValue = "a") String firstCurrency,
                               @RequestParam(value = "second_Currency", defaultValue = "b") String secondCurrency,
                               @RequestParam(value = "value_exchange", defaultValue = "0") String amount){
        double value = 0;
        try {
            value = Double.parseDouble(amount);
        }catch(NumberFormatException NFE){
            NFE.printStackTrace();
            return "redirect:/";
        }
        calculator.finalResult = calculator.convertDKKtoEU(firstCurrency, secondCurrency, value);
        return "redirect:/";
    }
}
