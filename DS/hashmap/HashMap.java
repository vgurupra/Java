package com.company.DS.hashmap;

import java.util.Arrays;

public class HashMap {
    private class Entry{
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" +
                    key +
                    ", " + value + '\'' +
                    ')';
        }

        public int getKey() {
            return key;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    private Entry[] array;
    private int count;

    public HashMap() {
        array = new Entry[5];
    }

    public void put(int key, String value){
        int index = hash(key);
        if(array[index] == null){
            array[index] = new Entry(key, value);
            count++;
            return;
        }
        else if(array[index] != null){
            if(array[index].key == key){
                array[index].value = value;
                return;
            }
            var newIndex = rehash(key);
            var originalHash = index;

            while (newIndex != originalHash){
                if(array[newIndex] == null){
                    array[newIndex] = new Entry(key, value);
                    count++;
                    return;
                }

                else if(array[newIndex] != null) {
                    if (array[newIndex].key == key) {
                        array[newIndex].value = value;
                        return;
                    }
                }
                newIndex = rehash(newIndex);
            }
            throw new IllegalStateException("Array is full");
        }
    }

    public String get(int key){
        int index = hash(key);
        if(array[index] == null)throw new IllegalArgumentException("The key is not present");
        if(array[index] != null){
            if(array[index].key == key)
                return array[index].value;
            else{
                int newIndex = rehash(key);
                int originalIndex = index;

                while (newIndex != originalIndex){
                    if(array[newIndex] == null)throw new IllegalArgumentException("The key is not present");
                    if(array[newIndex] != null)
                        if (array[newIndex].key == key)
                            return array[newIndex].value;
                    newIndex = rehash(newIndex);
                }
            }
        }
        throw new IllegalArgumentException("The key is not present");
    }

    public void remove(int key){
        int index = hash(key);
        if(array[index] == null)throw new IllegalArgumentException("The given key is not present");
        else if(array[index] != null){
            if(array[index].key == key){
                array[index] = null;
                count--;
                return;
            }
            int newIndex= rehash(key);
            int originalIndex = index;
            while (newIndex != originalIndex){
                if(array[newIndex] == null)throw new IllegalArgumentException("The given key is not present");
                else if(array[newIndex] != null) {
                    if (array[newIndex].key == key) {
                        array[newIndex] = null;
                        count--;
                        return;
                    }
                }
                newIndex = rehash(newIndex);
            }
        }
        throw new IllegalArgumentException("The given key is not present");
    }

    public void print(){
        System.out.println(Arrays.toString(array));
    }

    public int size(){
        return count;
    }

    private int hash(int key){
        return key % array.length;
    }

    private int rehash(int key){
        return (key + 1) % array.length;
    }
}
