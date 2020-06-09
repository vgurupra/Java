package com.company.DS.queues;

import java.util.Arrays;
import java.util.LinkedList;

public class Queue {
    private int fIndex;
    private int rIndex;
    private int count;
    private int[] array;

    public Queue(int size){
        array = new int[size];
        fIndex = 0;
        rIndex = 0;
        count = 0;
    }
    
    public void enqueue(int item){
        if(count >= array.length)throw new IllegalStateException("Queue is full");
        int index = rIndex % array.length;
        array[index] = item;
        rIndex++;
        count++;
    }

    public int dequeue(){
        if(count == 0)throw new IllegalStateException("Queue is empty");
        int index = fIndex % array.length;
        int value = array[index];
        fIndex++;
        count--;
        return value;
    }

    public int peek(){
        if(count == 0)throw new IllegalStateException("Queue is empty");
        return array[fIndex];
    }

    public boolean isEmpty(){
        if(count == 0)return true;
        return false;
    }

    public boolean isFull(){
        if(count == array.length)return true;
        return false;
    }

    public int[] sortDescending(int[] array){
        for(int i = 0; i < array.length; i++)
            for(int j = i + 1; j < array.length; j++)
                if(array[i] < array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
        return array;
    }

    public void reverseKElementsQueue(int k){
        if(count == 0)throw new IllegalStateException("Queue is empty");
        if(k >= count)throw new IllegalStateException("K value larger than elements in queue");
        int[] newArray = new int[k];

        for(int i = 0; i < k; i++)
            newArray[i] = array[i];

        newArray = sortDescending(newArray);
        for(int i = 0; i < newArray.length; i++)
            array[i] = newArray[i];

        var result = Arrays.copyOfRange(array,0, count);
        System.out.println(Arrays.toString(result));
    }

    public void printQueue(){
        System.out.println(Arrays.toString(array));
    }
}
