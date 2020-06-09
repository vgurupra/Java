package com.company.DS.queues;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueue {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackWithTwoQueue(){
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    public void enqueue(int item){
        queue1.add(item);
    }

    public int dequeue(){
        if(queue1.isEmpty() && queue2.isEmpty())throw new IllegalStateException("Queue is empty");
        int lastItem = Integer.MIN_VALUE;

        if(queue1.isEmpty()){
            while (!queue2.isEmpty())
                queue1.add(queue2.poll());
        }

        while(true){
            lastItem = queue1.poll();
            if(queue1.peek() == null)
                break;
            queue2.add(lastItem);
        }
        return lastItem;
    }
}
