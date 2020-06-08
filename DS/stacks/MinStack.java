package com.company.DS.stacks;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> originalStack;
    private Stack<Integer> minStack;

    public MinStack(){
        originalStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int item){
        originalStack.push(item);
        if(minStack.isEmpty())minStack.push(item);
        else if(minStack.peek() > item)minStack.push(item);
    }

    public int min(){
        if(minStack.isEmpty())throw new IllegalStateException("No elements in stack");
        return minStack.peek();
    }

    public void pop(){
        if(originalStack.isEmpty())throw new IllegalStateException("No elements in stack");
        else if(originalStack.peek() == minStack.peek()){
            originalStack.pop();
            minStack.pop();
        }
        else originalStack.pop();
    }
}
