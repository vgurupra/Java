package com.company.basics.exceptions;

public class AmountException extends RuntimeException {
    public AmountException(){
        super("Invalid Amount value entered. Enter a value greater than zero");
    }

    public AmountException(IllegalAmountException ex){
        super(ex);
    }
}
