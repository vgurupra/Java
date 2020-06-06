package com.company.basics.exceptions;

public class Demo {
    public void enterAmount(int value){
        if(value < 0)throw new IllegalAmountException();
        System.out.println("The entered value: "+value);
    }

    public void enterDiscount(int value){
        if(value < 0)throw new AmountException(new IllegalAmountException());
        System.out.println("The entered discount is: "+value);
    }
}
