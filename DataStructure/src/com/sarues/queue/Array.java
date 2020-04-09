package com.sarues.queue;

/**
 * 二次封装数组
 */
public class Array<E> {

    private E[] data;  //内置数组
    private int size;  //数组实际数据个数


    //有参构造
    public Array(int capacity) {
        this.data = (E[])new Object[capacity];  //创建泛型数组不能直接new  E[];
        size = 0;
    }


    //无参构造
    public Array() {
        this(10);  //指定内置数组默认大小为10
    }


    //返回内置数组size
    public int getSize(){
        return size;
    }


    //返回内置数组容量
    public int getCapacity(){
        return data.length;
    }


    //判断是否为空
    public boolean  isEmpty(){
        return  size == 0;
    }


    //在数组指定位置添加元素
    public void add(int index,E e){


        //判断插入位置是否合理
        if(index < 0 || index > size)
            throw  new IllegalArgumentException("add failed ,index is illegal");

        //判断数组空间是否满了
        if(size == data.length)
            resize(data.length * 2);

        //将指定位置的元素以及后面的元素全部后移一位
        for (int i = size - 1; i >= index  ; i--) {
            data[i + 1] = data[i];
        }

        //将指定的值赋值给数组指定位置
        data[index] = e;
        //维护数组实际数据大小加一
        size++;

    }


    //在数组末尾添加指定元素
    public void  addLast(E e) {
          add(size, e);
}


    //在数组首部添加指定元素
    public void addFirst(E e){
        add(0,e);
    }


    //重写toString方法
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d;  capacity = %d\n"),size,data.length);
        sb.append("[ ");
        for (int i = 0; i < size ; i++) {
            if(i != size -1)
                sb.append(data[i] + ",");
            else
                sb.append(data[i]);
        }
        sb.append(" ]");
        return sb.toString();
    }

    //获取指定索引位置上的数据
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("illegal index");
        return data[index];
    }

    public E getLast(){
        return get(size -1);
    };

    public E getFirst(){
        return get(0);
    };

    //将指定索引位置的元素改成指定的元素。
    public void set(int index,E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("illegal index");
        data[index] = e;
    }


    //判断数组是否包含指定元素
    public boolean contains(E e){
        for (int i = 0; i < size ; i++) {
            if(data[i] == e)
                return true;
        }
        return false;
    }

    //判断是否包含某元素并返回索引，否则返回-1
    public int find(E e){
        for (int i = 0; i < size ; i++) {
            if(data[i] == e)
                return i;
        }
        return -1;
    }

    //删除指定索引位置的元素
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("remove failed,illegal index");
        E e = data[index];
        for (int i = index + 1; i < size ; i++) {
            data[i - 1] = data[i];
        }
        size--;
        if(size == data.length/4 &&  data.length/2 != 0)
            resize(data.length/2);
        return e;
    }


    //动态扩容
    private void resize(int capacity) {
        E[] newData = (E[])new Object[capacity];
        for (int i = 0; i <size ; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }


    //删除尾部元素
    public E removeLast(){
        return remove(size - 1);
    }

    //删除首部元素
    public E removeFirst(){
        return remove(0);
    }

    //删除指定元素
    public void removeElement(E e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }
}