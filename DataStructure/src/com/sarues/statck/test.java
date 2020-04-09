package com.sarues.statck;



public class test {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        for (int i = 0; i < 5 ; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
