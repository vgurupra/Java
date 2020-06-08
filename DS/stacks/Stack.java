package com.company.DS.stacks;

import java.util.Arrays;

public class Stack {
    private int[] array;
    private int count;

    public Stack() {
        array = new int[5];
        count = 0;
    }

    public void push(int item){
        if(count < array.length){
            array[count++] = item;
            return;
        }
        var newArray = new int[array.length * 2];
        for(int i = 0; i < count; i++)
            newArray[i] = array[i];
        array = newArray;
        array[count++] = item;
    }

    public int pop(){
        if(count == 0)throw new IllegalStateException("Stack is empty");
        int value = array[count - 1];
        count--;
        return value;
    }

    public int peek(){
        if(count == 0)throw new IllegalStateException("Stack is empty");
        int value = array[count - 1];
        return value;
    }

    public boolean isEmpty(){
        if(count == 0)return true;
        return false;
    }

    public void print(){
        for(int i = 0; i < count; i++)
            System.out.print(array[i]+", ");
    }
}
