package com.company.DS.Arrays;

public class LinkedList {
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }
    private Node current;

    public void addFirst(int item){
        if(current == null){
            current = new Node(item);
            return;
        }
        var newNode = new Node(item);
        newNode.next = current;
        current = newNode;
    }

    public void addLast(int item){
        if(current == null){
            current = new Node(item);
            return;
        }
        Node previous = current;
        while (previous.next != null)
            previous = previous.next;
        var newNode = new Node(item);
        previous.next = newNode;
    }

    public boolean contains(int item){
        Node temp = current;
        if(current == null)return false;
        while (temp != null){
            if(temp.value == item)return true;
            temp = temp.next;
        }
        return false;
    }

    public void removeFirst(){
        if(current == null)return;
        Node newCurrent = current.next;
        current = newCurrent;
    }

    public void removeLast(){
        if(current == null)return;
        if(current.next == null){
            current = null;
            return;
        }

        Node temp = current;
        Node previous = null;

        while(temp.next != null){
            previous = temp;
            temp = temp.next;
        }
        previous.next = null;
    }

    public int size(){
        int size = 0;
        if(current == null)return  size;
        Node temp = current;

        while (temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }

    public int indexOf(int item){
        int index = 0;
        Node temp = current;

        if(!contains(item))return -1;
        while (temp != null){
            if(temp.value == item)break;
            index++;
            temp = temp.next;
        }
        return index;
    }

    public int[] toArray(){
        int[] array = new int[size()];
        int index = 0;
        Node temp = current;
        while (temp != null){
            array[index++] = temp.value;
            temp = temp.next;
        }
        return array;
    }

    public void reverse(){
        if(current == null)return;
        Node next = null;
        Node previous = null;
        Node temp = current;

        while(temp != null){
            next = temp.next;
            temp.next = previous;
            previous = temp;
            temp = next;
        }
        current = previous;
    }

    public void getKthFromTheEnd(int k){
        if(k <= 0)throw new IllegalStateException("Invalid value of k passed");
        if(current == null)return;
        Node firstPointer = current;
        Node secondPointer = current;

        for(int i = 0; i < (k - 1); i++){
            if(secondPointer.next == null)throw new IllegalStateException("Invalid value of k passed");
            secondPointer = secondPointer.next;
        }
        if(secondPointer == null)throw new IllegalStateException("Invalid value of k passed");

        while(secondPointer.next != null){
            secondPointer = secondPointer.next;
            firstPointer = firstPointer.next;
        }
        System.out.println(firstPointer);
    }

    public void findMiddleNode(){
        if(current == null)return;
        Node first = current;
        Node second = current;

        while((second != null) && (second.next != null)){
            second = second.next.next;
            first = first.next;
        }
        System.out.println(first);
    }

    public Node isLoopPresent(){
        if(current == null)return null;
        Node first = current;
        Node second = current;

        while((first != null) && (second != null) && (second.next != null)){
            if(first == second)break;
            second = second.next.next;
            first = first.next;
        }
        return first;
    }

    public Node startOfLoop(){
        if(isLoopPresent() == null)return null;
        Node first = current;
        Node second = isLoopPresent();

        while (first != second){
            first = first.next;
            second = second.next;
        }
        return first;
    }

    public void print(){
        Node temp = current;
        while(temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
