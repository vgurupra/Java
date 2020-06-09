package com.company.DS.queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class DemoQueues {
    public void reverseQueue(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();
        var reversedQueue = new ArrayDeque<Integer>();

        for(var item : queue)
            stack.push(item);

        while (!stack.isEmpty())
            reversedQueue.add(stack.pop());

        System.out.println("Original Queue: "+queue);
        System.out.println("Reversed Queue: "+reversedQueue);
    }
}
