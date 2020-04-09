package com.sarues.linkedlist;

public class LinkedList<E> {


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
    private int size;        //链表中节点数量



    //构造函数
    public LinkedList() {
        this.dummyHead = new Node(null,null);
        size = 0;
    }


    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    //增
    //在指定索引位置插入元素，（链表一般是不存在索引的，只是为了思维练习）
    public void add(int index,E e){
        if(index < 0 || index  > size)
            throw new IllegalArgumentException("add failed, illegal index");
        Node prev = dummyHead;
        for (int i = 0; i < index ; i++) {
            prev = prev.next;
        }
//        Node node = new Node(e);
//        node.next = prev.next;
//        prev.next = node;
        prev.next = new Node(e,prev.next); //上面三句话可以用这一句话代替。
        size++;
    }

    public void addLast(E e){
        add(size,e);
    }

    public void addFirst(E e){
        add(0,e);
    }


    //删
    public E remove(int index){
        if(index < 0 || index >= size )
            throw new IllegalArgumentException("remove failed,illegal index");
        Node prev = dummyHead;
        for (int i = 0; i <index ; i++) {
            prev = prev.next;
        }

        Node cur = prev.next;
        E ret = cur.e;
        prev.next = cur.next;
        cur.next = null;
        size--;
        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size - 1);
    }

    //改
    public  void  set(int index,E e){
        if(index < 0 || index >=size)
            throw new IllegalArgumentException("set failed,illegal index");
        Node cur = dummyHead.next;
        for (int i = 0; i <index ; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }


    //查
    public  E get(int index){
        if(index < 0 || index >=size)
            throw new IllegalArgumentException("get failed,illegal index");
        Node cur = dummyHead.next;
        for (int i = 0; i <index ; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }


    //判断是否包含某元素
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.e.equals(e))
                return true;
            cur = cur.next;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            sb.append(cur.e + "——>");
            cur = cur.next;
        }

        sb.append("null");
        return sb.toString();
    }
}
