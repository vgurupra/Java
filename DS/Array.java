package com.company.DS;

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

    public void print(){
        for(int i = 0; i < count; i++)
            System.out.println(array[i]);
    }
}
