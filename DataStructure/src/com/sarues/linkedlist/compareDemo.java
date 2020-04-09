package com.sarues.linkedlist;

import com.sarues.statck.ArrayStack;
import com.sarues.statck.Stack;

import java.util.Random;

public class compareDemo {

    public static void main(String[] args) {
        int opCount = 10000000;
        ArrayStack<Integer> stack1 = new ArrayStack();
        LinkeListStack<Integer> stack2 = new LinkeListStack();
        System.out.println("ArrayStack:" + getTime(stack1,opCount) + "s");
        System.out.println("LinkedListStack:" + getTime(stack2,opCount) + "s");
    }

    public static double  getTime(Stack<Integer> stack,int opCount){
        long start = System.currentTimeMillis();
        for (int i = 0; i <opCount ; i++) {
            Random r = new Random();
            stack.push(r.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i <opCount ; i++) {
            stack.pop();
        }

        long end = System.currentTimeMillis();
        double ret = (end - start)/1000.0;
        return ret;
    }

}
