package com.company.basics.generics;

public class Utils {
    public static <T extends Comparable<T>>T max(T first, T second){
        return (first.compareTo(second) >= 0) ? first : second;
    }

    public static <K, V> void printKeyValue(K key, V value){
        System.out.println("The key: "+key+", Value: "+value);
    }

    public static void printList(GenericList<? super User> users){
        users.addItem(new Instructor(14));
    }
}
