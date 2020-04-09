package com.sarues.queue;

public class test2 {
    public static void main(String[] args) {
        LoopQueue<Integer> lqueue = new LoopQueue<>();
        LinkedListQueue<Integer> listQueue = new LinkedListQueue<>();
        LinkedListDummyHeadQueue dummyHeadQueue = new LinkedListDummyHeadQueue();
        for (int i = 0; i < 10 ; i++) {
            dummyHeadQueue.enqueue(i);
            System.out.println(dummyHeadQueue);
            if(i % 3 == 2){
                dummyHeadQueue.dequeue();
                System.out.println(dummyHeadQueue);
            }
        }
    }
}
