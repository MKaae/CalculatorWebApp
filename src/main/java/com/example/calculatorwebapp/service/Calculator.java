package com.example.calculatorwebapp.service;

import org.springframework.stereotype.Repository;

@Repository
public class Calculator {
    private double theResult = 0;
    public double finalResult = 0;
    public Calculator(){
    }
    public Calculator(double finalResult){
        this.finalResult = finalResult;
    }
    public double convertDKKtoEU(String fromCurrency, String toCurrency, double amount){
        double dkkToEurExchangeRate = 7.69;
        double result = 0;
        if(fromCurrency == null || toCurrency == null || amount == 0){
            return 0;
        }
        if(fromCurrency.equals("DKK") && toCurrency.equals("EUR")){
            result = amount * dkkToEurExchangeRate;
        }
        else if(fromCurrency.equals("EUR") && toCurrency.equals("DKK")){
            result = amount / dkkToEurExchangeRate;
        }
        return result;
    }
}
