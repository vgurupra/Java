package com.company.basics.exceptions;

public class IllegalAmountException extends RuntimeException{
    public IllegalAmountException(String msg){
        super(msg);
    }

    public IllegalAmountException(){
        super("Value entered should be greater than zero.");
    }
}
