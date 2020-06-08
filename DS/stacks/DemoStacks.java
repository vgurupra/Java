package com.company.DS.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class DemoStacks {
    public void reverseString(String data){
        if(data == null)throw new IllegalArgumentException("Invalid Argument passed");
        Stack<Character> stack = new Stack<>();

        for(var item : data.toCharArray())
            stack.push(item);

        while (!stack.isEmpty())
            System.out.print(stack.pop());
    }

    public boolean balancedParenthesis(String data){
        if(data == null)throw new IllegalArgumentException("Invalid Argument passed");
        Stack<Character> stack = new Stack<>();

        for(var item : data.toCharArray())
            if((item == '(') || (item == '[') || (item == '{') || (item == '<'))
                stack.push(item);
            else if((item == ')') || (item == ']') || (item == '}') || (item == '>')){
                if(item == ')' && stack.peek() == '(')stack.pop();
                else if(item == ']' && stack.peek() == '[')stack.pop();
                else if(item == '}' && stack.peek() == '{')stack.pop();
                else if(item == '>' && stack.peek() == '<')stack.pop();
            }

        if(stack.isEmpty())
            return true;
        return false;
    }
}
