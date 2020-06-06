package com.company.basics.taxReport;

public class TaxReport {
    ITaxCalculator calculator;
    public TaxReport(ITaxCalculator calculator){
        this.calculator = calculator;
    }

    public void display(){
        calculator.calculateTax();
        System.out.println("Within TaxReport class");
    }

    public void setNewImplementation(ITaxCalculator calculator){
        System.out.println("New Implementation");
        this.calculator = calculator;
    }
}
