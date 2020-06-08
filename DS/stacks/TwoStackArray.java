package com.company.DS.stacks;

import java.util.Arrays;

public class TwoStackArray {
    private int[] array;
    private int pIndex1;
    private int pIndex2;

    public TwoStackArray(int size){
        array = new int[size];
        pIndex1 = 0;
        pIndex2 = array.length - 1;
    }

    public void push1(int item){
        if((pIndex1 > pIndex2) || (pIndex1 + 1 >= array.length))throw new IllegalStateException("Array Overflown");
        array[pIndex1++] = item;
    }

    public void push2(int item){
        if((pIndex2 < pIndex1) || (pIndex2 - 1 < 0))throw new IllegalStateException("Array Overflown");
        array[pIndex2--] = item;
    }

    public int pop1(){
        if(pIndex1 == 0)throw new IllegalStateException("Array is empty");
        int value = array[pIndex1 - 1];
        pIndex1--;
        return value;
    }

    public int pop2(){
        if(pIndex2 >= array.length)throw new IllegalStateException("Array is empty");
        int value = array[pIndex2 + 1];
        pIndex2++;
        return value;
    }

    public boolean isEmpty1(){
        if(pIndex1 > pIndex2)return false;
        return true;
    }

    public boolean isEmpty2(){
        if(pIndex2 < pIndex1)return false;
        return true;
    }

    public boolean isFull1(){
        if(pIndex1 > pIndex2)return true;
        return false;
    }

    public boolean isFull2(){
        if(pIndex2 < pIndex1)return true;
        return false;
    }

    public void printArray(){
        System.out.println(Arrays.toString(array));
    }
}
