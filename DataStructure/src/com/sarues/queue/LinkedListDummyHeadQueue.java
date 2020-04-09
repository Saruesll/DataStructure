package com.sarues.queue;

public class LinkedListDummyHeadQueue<E> implements Queue<E> {


    //内部类，表示节点。
    private class Node{
        public  E e ;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e,null);
        }

        public Node() {
            this(null,null);
        }
    }

    private Node dummyHead;  //虚拟头节点
    private Node tail;
    private int size;        //链表中节点数量



    //构造函数
    public LinkedListDummyHeadQueue() {
        this.dummyHead = new Node(null,null);
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if(tail == null){
            dummyHead.next = new Node(e);
            tail = dummyHead.next;
        }
        else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("cannot dequeue from an empty queue");
        Node ret = dummyHead.next;
        dummyHead.next = dummyHead.next.next;
        ret.next = null;
        if(dummyHead.next == null)
            tail = null;
        size--;
        return ret.e;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("cannot get from an empty queue ");

        return dummyHead.next.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("queue front [");
        Node cur = dummyHead.next;
        while (cur != null){
            sb.append(cur.e + "——>");
            cur = cur.next;
        }

        sb.append("null ] tail");
        return sb.toString();
    }
}
