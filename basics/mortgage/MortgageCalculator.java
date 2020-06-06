package com.company.basics;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    float principal, roi;
    int period;

    final int MONTHS = 12;
    final int PERCENT = 100;

    public MortgageCalculator(){
        this.principal =  setPrincipal();
        this.roi = setROI();
        this.period = setPeriod();
    }

    private float setPrincipal(){
        var scanner = new Scanner(System.in);
        float principal;
        while (true){
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextFloat();
            if(principal >= 1000 && principal <= 1000000)break;
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }
        return principal;
    }

    private float setROI(){
        var scanner = new Scanner(System.in);
        while (true){
            System.out.print("Annual Interest Rate: ");
            roi = scanner.nextFloat();
            if(roi > 0 && roi <= 30)break;
            System.out.println("Enter a value greater than 0 and less than or equal to 30");
        }
        roi = roi / MONTHS;
        roi = roi / PERCENT;
        return roi;
    }

    private int setPeriod(){
        var scanner = new Scanner(System.in);
        while (true){
            System.out.print("Period (Years): ");
            period = scanner.nextInt();
            if(period > 0 && period <= 30)break;
            System.out.println("Enter a value greater than 0 and less than or equal to 30");
        }
        period = period * MONTHS;
        return period;
    }

    public void calculateMortgage(){
        var currency = NumberFormat.getCurrencyInstance();
        var mortgage = (principal * (roi * Math.pow((1 + roi), period)))/
                        (Math.pow((1 + roi), period) - 1);
        System.out.print("Mortgage: "+currency.format(mortgage));
        System.out.println();
    }

    public void calculateSchedule(){
        var currency = NumberFormat.getCurrencyInstance();
        System.out.println("Payment Schedule");
        System.out.println("----------------");
        for(int p = 0; p <= period; p++){
            var balance = principal * (Math.pow((1 + roi), period) - Math.pow((1 + roi), p))/
                          (Math.pow((1 + roi), period) - 1);
            System.out.println(currency.format(balance));
        }
    }
}
