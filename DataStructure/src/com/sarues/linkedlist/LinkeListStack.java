package com.sarues.linkedlist;

import com.sarues.statck.Stack;

public class LinkeListStack<E> implements Stack<E> {
    private LinkedList<E> linkedList;

    public LinkeListStack() {
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }


    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
         linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E  peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("stack top [");
        for (int i = 0; i < linkedList.getSize() ; i++) {
            sb.append(linkedList.get(i));
            if(i != linkedList.getSize() - 1)
                sb.append(", ");
        }
        sb.append("] stack bottom");
        return sb.toString();
    }
}
