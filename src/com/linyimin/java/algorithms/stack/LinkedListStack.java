package com.linyimin.java.algorithms.stack;

import java.util.Iterator;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 01:06 2018/6/23
 */

public class LinkedListStack<T> implements Iterable<T>{

    // 定义链表的节点
    private class Node{
        T value;
        Node next;

        public Node(T value){
            this.value = value;
        }
    }

    // 栈的大小
    private int N;

    // 栈的头指针
    private Node head;

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return this.N;
    }

    public void push(T value){
        Node oldFirst = this.head;
        this.head = new Node(value);
        this.head.next = oldFirst;
        this.N++;
    }

    public T pop(){
        if(this.head != null){
            T value = this.head.value;
            this.head = this.head.next;
            this.N--;
            return value;
        }
        return null;
    }

    // 实现Iterator
    class StackIterator implements Iterator<T>{
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            return value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }
}

