package com.sarues.queue;


public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front,tail;
    private int size;

    public LoopQueue(int capacity) {     //有参构造，指定内置数组大小
        data =(E []) new Object[capacity +1];   //故意浪费一个数组空间
        front = 0;
        tail  = 0;
        size  = 0;
    }

    public LoopQueue() {  //无参构造，默认数组大小为10
        this(10);
    }

    //入队
    @Override
    public void enqueue(E e) {
        if((tail + 1) % data.length == front)     //判断队列是否满了
            resize(getCapacity() * 2);    //满了的话就扩容
        data[tail] = e;                           //入队赋值
        tail = (tail + 1)%data.length;            //维护tail++
        size++;                                    //维护size++
    }

    //扩容
    private void resize(int capacity) {
        E[] newdata =  (E[])new Object[capacity + 1];   //新建一个新数组
        for (int i = 0; i < size; i++) {                //循环遍历将内置数组的值复制到新数组
            newdata[i] = data[(i + front)%data.length];
        }

        data = newdata;     //将新数组替换旧内置数组
        front = 0;          //维护front和tail
        tail = size;

    }

    //出队
    @Override
    public E dequeue() {
        if(isEmpty())               //判断是否为空
            throw new IllegalArgumentException("cannot dequeue from a empty queue");
        E ret = data[front];       //获取队首元素
        data[front] = null;        //将内置数组队首元素置空
        front = (front + 1) % data.length; //维护front++
        size--;                            //维护size--
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0)  //缩容
            resize(getCapacity() / 2);
        return ret;                        //返回队首值
    }


    //获取队首元素
    @Override
    public E getFront() {
        if(isEmpty())        //判断是否为空
            throw new IllegalArgumentException("queue is empty,cannot get from a empty queue");
        return data[front];    //返回队首元素
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LoopQueue： size = %d   capacity = %d \n",size,getCapacity()));
        sb.append("front [ ");
        for (int i = front; i != tail  ; i =  (i + 1) % data.length) {
             sb.append(data[i]);
             if( i != tail)
                 sb.append(", ");
        }
        sb.append("] tail");
        return sb.toString();
    }
}
