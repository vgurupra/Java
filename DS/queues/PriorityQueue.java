package com.company.DS.queues;

public class PriorityQueue {
    private int fIndex;
    private int rIndex;
    private int count;
    private int[] array;

    public PriorityQueue(int size){
        array = new int[size];
    }

    public void add(int item){
        if(count == array.length)throw new IllegalStateException("Queue is full");
        int index = rIndex % array.length;
        array[index] = item;
        rIndex++;
        count++;
    }

    public int remove(){
        if(count == 0)throw new IllegalStateException("Queue is empty");
        int smallestItemIndex = -1;
        int smallestItem = Integer.MAX_VALUE;

        for(int i = 0; i < count; i++)
            if(array[i] < smallestItem){
                smallestItem = array[i];
                smallestItemIndex = i;
            }

        for(int i = smallestItemIndex; i < count - 1; i++)
            array[i] = array[i + 1];
        count--;
        return smallestItem;
    }

    public int peek(){
        if(count == 0)throw new IllegalStateException("Queue is empty");
        int smallestItemIndex = -1;
        int smallestItem = Integer.MAX_VALUE;

        for(int i = 0; i < count; i++)
            if(array[i] < smallestItem){
                smallestItem = array[i];
                smallestItemIndex = i;
            }
        return smallestItem;
    }

    public boolean isEmpty(){
        if(count == 0)return true;
        return false;
    }
}
