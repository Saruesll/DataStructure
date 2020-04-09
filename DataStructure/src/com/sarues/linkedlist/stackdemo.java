package com.sarues.linkedlist;

public class stackdemo {
    public static void main(String[] args) {
        LinkeListStack<Integer> stack = new LinkeListStack<>();
        for (int i = 0; i <10 ; i++) {
            stack.push(i);
            System.out.println(stack);
            if(i % 3 == 2) {
                stack.pop();
                System.out.println(stack);
            }
        }
    }
}
