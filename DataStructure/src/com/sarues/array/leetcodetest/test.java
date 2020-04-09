package com.sarues.array.leetcodetest;

import com.sarues.array.Array;

public class test {



    public static void main(String[] args) {
        Array<Integer> a2 = new Array<>();
        for (int i = 0; i < 10 ; i++) {
            a2.addLast(i);
        }

        System.out.println(a2.toString());
    }
}
