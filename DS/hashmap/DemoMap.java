package com.company.DS.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DemoMap {
    private class Entry{
        private int first;
        private int second;

        public Entry(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "(" + first +
                    ", " + second +
                    ')';
        }
    }

    public char getFirstNonRepeatedCharacter(String items){
        items = items.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();

        for(var item : items.toCharArray()){
            var count = (map.get(item) == null) ? 0 : map.get(item);
            map.put(item, count + 1);
        }

        char nonRepeated = ' ';
        for (var item : items.toCharArray())
            if(map.get(item) == 1){
                nonRepeated = item;
                break;
            }
        return nonRepeated;
    }

    public char getFirstRepeatedCharacter(String values){
        values = values.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();

        for(var item : values.toCharArray()){
            var count = (map.get(item) == null) ? 0 : map.get(item);
            map.put(item, count + 1);
        }

        char repeatedChar = ' ';
        for (var item : values.toCharArray())
            if(map.get(item) > 1){
                repeatedChar = item;
                break;
            }
        return repeatedChar;
    }

    public int getMostRepeatedInteger(int[] items){
        if(items.length == 0)throw new IllegalArgumentException("The input array is empty");
        if(items == null)throw new IllegalArgumentException("The input array is null");

        Map<Integer, Integer> map = new HashMap<>();
        for(var item : items){
            var count = (map.get(item) == null) ? 0 : map.get(item);
            map.put(item, count + 1);
        }

        int mostRepeated = Integer.MIN_VALUE;
        for (var item : map.entrySet())
            if(item.getValue() > mostRepeated)
                mostRepeated = item.getValue();
        return mostRepeated;
    }

    public void countPairsWithDiff(int[] items, int k){
        if(items.length == 0)throw new IllegalArgumentException("The input array is empty");
        if(items == null)throw new IllegalArgumentException("The input array is null");

        Map<Integer, Integer> map = new HashMap<>();
        for(var item : items){
            var count = (map.get(item) == null) ? 0 : map.get(item);
            map.put(item, count + 1);
        }

        ArrayList<Entry> arrayList = new ArrayList<>();
        for(var item: items){
            if(map.get(item + k) != null)
                arrayList.add(new Entry(item, item + k));
        }
        System.out.println(arrayList);
        System.out.println("Count: "+arrayList.size());
    }

    private int findIndexOf(int[] array, int item){
        for(int i = 0; i < array.length; i++)
            if(array[i] == item)
                return i;
        return -1;
    }

    public void twoSum(int[] items, int target){
        if(items.length == 0)throw new IllegalArgumentException("The input array is empty");
        if(items == null)throw new IllegalArgumentException("The input array is null");

        Map<Integer, Integer> map = new HashMap<>();
        for(var item : items){
            var count = (map.get(item) == null) ? 0 : map.get(item);
            map.put(item, count + 1);
        }

        for(int i = 0; i < items.length; i++)
            if(map.get(target - items[i]) != null){
                System.out.println(new Entry(i, findIndexOf(items,target - items[i])));
                return;
            }
        System.out.println("No such items present");
    }
}
