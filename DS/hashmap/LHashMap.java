package com.company.DS.hashmap;

import java.util.LinkedList;

public class LHashMap {
    private class Entry{
        private int key;
        private String value;

        public Entry(int key, String value){
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
    private LinkedList<Entry>[] array;

    public LHashMap() {
        array = new LinkedList[5];
    }

    public void put(int key, String value){
        int index = hash(key);
        if(array[index] == null){
            array[index] = new LinkedList<>();
            array[index].addLast(new Entry(key, value));
            return;
        }
        for(var item : array[index])
            if(item.getKey() == key){
                item.setValue(value);
                return;
            }
        array[index].addLast(new Entry(key, value));
    }

    public String get(int key){
        int index = hash(key);
        if(array[index] == null)
            return null;
        for(var item : array[index])
            if(item.getKey() == key)
                return item.getValue();
        return null;
    }

    public void remove(int key){
        int index = hash(key);
        if(array[index] == null)
            throw new IllegalArgumentException("The key is not present");
        for(var item : array[index])
            if(item.getKey() == key){
                var rIndex = array[index].indexOf(item);
                var rItem = array[index].remove(rIndex);
                System.out.println(rItem);
                return;
            }
        throw new IllegalArgumentException("The key is not present");
    }

    private int hash(int key){
        return key % array.length;
    }
}
