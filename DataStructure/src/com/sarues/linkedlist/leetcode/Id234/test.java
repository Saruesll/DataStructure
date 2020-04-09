package com.sarues.linkedlist.leetcode.Id234;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        list.add(-129);
        list.add(-129);
        for (int i = 0; i < list.size()/2; i++) {
            if(!list.get(i) .equals(list.get(list.size() - i - 1))){
                System.out.println(false);
                return;
            }

        }
        System.out.println(true);
    }
}
