package com.sarues.tree;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.Random;
import java.util.Stack;

public class BST<E extends Comparable> {

    private class Node{
        public E e;
        public Node left;
        public Node right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //向二分搜索树添加元素
    public void add(E e){
        root = add(root,e);
    }

    //向以root为根节点的树添加元素e，用于递归
    private Node add(Node root, E e) {
        if(root == null){     //递归终止条件，null也算是一棵二叉树。
            return new Node(e);
        }

        if(e.compareTo(root.e) < 0)
            root.left = add(root.left,e);
        else if (e.compareTo(root.e) > 0)
            root.right = add(root.right,e);

        return root;
    }

    /**
     * 查看树中是否包含某元素
     *
     */

    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node root, E e) {
        if(root == null)
            return false;
        if(e.compareTo(root.e) == 0)
            return true;
        else if(e.compareTo(root.e) < 0)
            return contains(root.left,e);
        else  //e.compareTo(root.e) > 0
            return contains(root.right,e);
    }

    /**
     *  遍历树中的元素
     *  三种遍历方式（前中后序遍历）
     */

    //1.前序遍历
    public void preOrder(){
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node root) {
        if(root == null)
            return;
        System.out.print(root.e);
        preOrder(root.left);
        preOrder(root.right);
    }

    //前序遍历非递归实现
    public void preOrder2(){

        if(root == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            Node node = stack.pop();
            System.out.print(node.e);
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }

        System.out.println();
    }


    //2.中序遍历
    public void indexOrder(){
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node root) {
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.e);
        inOrder(root.right);
    }

    //中序遍历非递归实现
    public void indexOrder2(){
        if(root == null)
            System.out.println("该树是一棵空树");
        Node cur = root;          //定义节点记录位置
        Stack<Node> stack = new Stack<>();   //创建栈
        while (!stack.empty() || cur != null){   //循环条件是栈为空或记录节点不为空
              while (cur!= null){   //先将左节点全部入栈
                  stack.push(cur);
                  cur = cur.left;
              }
              Node top = stack.pop();   //入栈完毕后访问最后一个没有左节点的节点（当前栈顶节点，将该节点出栈）
              System.out.print(top.e);   //输出该节点
              cur = top.right;           //然后将记录节点转移到该节点的右子树根节点（右子树又会重复上边的过程。）
        }
    }

    //3.后序遍历
    public void lastOrder(){
        lastOrder(root);
        System.out.println();
    }

    private void lastOrder(Node root) {
        if(root == null)
            return;
        lastOrder(root.left);
        lastOrder(root.right);
        System.out.print(root.e);
    }


    //后序遍历非递归实现
    public void lastOrder2(){
      if(root == null)
          System.out.println("空树");
      Stack<Node> stack  = new Stack<>();
      Node node = root;
      Node prev = null;
      while (!stack.empty() || node != null){
          while (node != null){
              stack.push(node);
              node = node.left;
          }

          Node snode = stack.peek();
          if(snode.right == null || prev == snode.right){
              stack.pop();
              prev = snode;
              System.out.print(snode.e);
          }  else {
              node = snode.right;
          }
      }
    }

    /**
     * 最大元素相关问题
     * @return
     */
    //查找最大元素
    public E findMax(){
        if(root == null)
            throw new IllegalArgumentException("空树");
        return findMax(root).e;
    }

    //返回最大元素指定的节点
    private Node findMax(Node root) {
        if(root.right == null)
            return root;
        return findMax(root.right);

    }

    //删除最大元素节点
    public E removeMax(){
        E max = findMax();
        root = removeMax(root);
        return max;
    }

    private Node removeMax(Node root) {
        if(root.right == null){
            Node left = root.left;
            root.left = null;
            size--;
            return left;
        }

        root.right = removeMax(root.right);
        return root;
    }


    /**
     * 最小元素相关问题
     * @return
     */
    //查找最小元素
    public E findMin(){
        if(root == null)
            throw new IllegalArgumentException("空树");
        return findMin(root).e;
    }

    //返回最小元素的节点
    private Node findMin(Node root) {
        if(root.left == null)
            return root;
        return findMin(root.left);
    }

    //删除最小元素节点
    public E removeMin(){
        E min = findMin();
        root = removeMin(root);
        return min;
    }

    private Node removeMin(Node root) {
        if(root.left == null){
            Node rightNode = root.right;
            root.right = null;
            size--;
            return rightNode;

        }

        root.left = removeMin(root.left);
        return root;
    }


    //删除指定元素
    public void remove(E e){
        root = remove(root,e);
    }

    //返回删除指定元素后的新的根节点。
    private Node remove(Node root,E e) {
        if(root == null)
            return null;
        if(e.compareTo(root.e) < 0)
            root.left = remove(root.left,e);
        else if(e.compareTo(root.e) > 0)
            root.right  = remove(root.right,e);
        else {
            if(root.left == null){
                Node rightNode = root.right;
                root.right = null;
                size--;
                return rightNode;
            }
            if(root.right == null){
                Node leftNode = root.left;
                root.left = null;
                size--;
                return leftNode;
            }

            Node successor = findMin(root.right);
            successor.right = removeMin(root.right);
            successor.left = root.left;
            root.left = root.right = null;
            return successor;
        }

        return root;
    }
}
