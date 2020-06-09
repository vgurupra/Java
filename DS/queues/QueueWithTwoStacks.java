package com.company.DS.queues;

import java.util.Stack;

public class QueueWithTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueWithTwoStacks() {
        stack1 = new Stack<>();
        stack2 =  new Stack<>();
    }

    public void enqueue(int item){
        stack1.push(item);
    }

    public int dequeue(){
        if(stack1.isEmpty() && stack2.isEmpty())throw new IllegalStateException("Queue is empty");
        if(stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        return stack2.pop();
    }

    public int peek(){
        if(stack1.isEmpty() && stack2.isEmpty())throw new IllegalStateException("Queue is empty");
        if(stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        return stack2.peek();
    }

    public boolean isEmpty(){
        if(stack1.isEmpty() && stack2.isEmpty())return true;
        return false;
    }
}
