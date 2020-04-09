package com.sarues.linkedlist;

public class demo {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList =  new LinkedList<>();
        for (int i = 0; i < 10 ; i++) {
            linkedList.addLast(i);
            System.out.println(linkedList);
        }

        linkedList.addFirst(666);
        linkedList.addLast(999);
        linkedList.add(2,888);
        System.out.println(linkedList);

        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.remove(2);
        System.out.println(linkedList);
    }
}
