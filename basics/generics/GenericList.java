package com.company.basics.generics;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericList<T> implements Iterable<T>{
    private T[] array;
    private int count;
    public GenericList(){
        array = (T[])new Object[10];
        count = 0;
    }

    public void addItem(T item){
        if(count >= 10)throw new IllegalStateException("Array limit reached");
        array[count] = item;
        count++;
    }

    public T getItem(int index){
        if(index >= count)throw new IllegalArgumentException("Index not in array");
        return array[index];
    }

    public void removeItem(T item){
        int index = findIndex(item);
        if(index == -1)throw new IllegalArgumentException("Item not in list");
        for(int i = index; i <= count; i++)
            array[i] = array[i + 1];
        count--;
    }

    private int findIndex(T item){
        for(int i = 0; i < count; i++){
            if(array[i] == item)return i;
        }
        return -1;
    }

    public void printArray(){
        ArrayList<T> result = new ArrayList<>();
        for(int i = 0; i < count; i++)
            result.add(array[i]);
        System.out.println(result);
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(this);
    }

    private class ListIterator implements Iterator<T>{
        private GenericList<T> object;
        private int index;
        public ListIterator(GenericList<T> object){
            this.object = object;
        }

        @Override
        public boolean hasNext() {
            if(index < object.count)return true;
            return false;
        }

        @Override
        public T next() {
            T item = object.array[index];
            index++;
            return item;
        }
    }
}
