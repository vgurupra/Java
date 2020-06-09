package com.company.DS.arrays;

import java.util.ArrayList;

public class Array {
    private int[] array;
    private int count;

    public Array(int size){
         array = new int[size];
    }

    public void insert(int item){
        if(count < array.length){
            array[count] = item;
            count++;
            return;
        }

        int[] newArray = new int[array.length * 2];
        for(int i = 0; i < count; i++)
            newArray[i] = array[i];
        newArray[count] = item;
        array = newArray;
        count++;
    }

    public void removeAt(int index){
        if(index >= count)
            throw new IllegalStateException("Index out of bound");
        for(int i = index; i < count; i++)
            array[i] = array[i + 1];
        count--;
    }

    public int indexOf(int item){
        int index = -1;
        for(int i = 0; i < count; i++)
            if(array[i] == item){
                index = i;
                break;
            }
        return index;
    }

    public int max(){
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < count; i++)
            if(array[i] > maxValue)
                maxValue = array[i];
        return maxValue;
    }

    private boolean isPresent(int[] array, int item){
        for(var value : array)
            if(value == item)
                return true;
        return false;
    }

    public ArrayList<Integer> intersect(int[] other){
        var commonItems = new ArrayList<Integer>();
        for(var item : array)
            if(isPresent(other, item))
                commonItems.add(item);
        return commonItems;
    }

    public ArrayList<Integer> reverse(){
        var reversed = new ArrayList<Integer>();
        for(int i = count - 1; i >=0; i--)
            reversed.add(array[i]);
        return reversed;
    }

    public void insertAt(int item, int index){
        if(index >= count)
            throw new IllegalStateException("Index position not a part of the original array");

        if(count >= array.length){
            int[] newArray = new int[array.length * 2];
            for(int i = 0; i < count; i++)
                newArray[i] = array[i];
            array = newArray;
        }

        for(int i = count - 1; i >= index; i--)
            array[i + 1] = array[i];
        array[index] = item;
        count++;
    }

    public void print(){
        for(int i = 0; i < count; i++)
            System.out.println(array[i]);
    }
}
