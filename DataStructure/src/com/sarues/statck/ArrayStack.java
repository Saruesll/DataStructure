package com.sarues.statck;



public class ArrayStack<E> implements Stack<E> {
    private Array<E> array;  //该栈的底层是自己定义的动态数组。

    public ArrayStack(int capacity) {    //有参构造，指导栈的大小
        array = new Array<>(capacity);
    }

    public ArrayStack() {   //无参构造，默认大小
        array = new Array<>();
    }

    @Override
    public int getSize() {   //返回栈中的数据个数
        return array.getSize();
    }


    public int getCapacity() {  //返回栈的容量
        return array.getCapacity();
    }

    @Override
    public boolean isEmpty() { //判断栈是否为空
        return array.isEmpty();
    }

    @Override
    public void push(E e) {  //入栈（往栈顶添加元素）
        array.addLast(e);
    }

    @Override
        public E pop() {   //出栈（返回并删除栈顶元素）
        return array.removeLast();
    }

    @Override
    public E peek() {    //返回栈顶元素
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack [ ");
        for (int i = 0; i < array.getSize() ; i++) {
            sb.append(array.get(i));
            if(i != array.getSize() - 1)
                sb.append(", ");
        }
        sb.append(" ] top");
        return sb.toString();
    }
}
