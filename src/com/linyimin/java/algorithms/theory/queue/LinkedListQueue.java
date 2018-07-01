package com.linyimin.java.algorithms.theory.queue;

import java.util.Iterator;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 14:06 2018/6/23
 */
public class LinkedListQueue<T> implements Iterable<T> {
    // 记录链表（队列）的长度
    private int N;
    // 队列的头指针
    private Node head;
    // 队列的尾指针
    private Node tail;

    // 指定链表的节点
    private class Node{
        T value;
        Node next;

        public Node(T value){
            this.value = value;
        }
    }

    public boolean isEmpty(){
        return this.N == 0;
    }

    public int size(){
        return this.N;
    }

    public void enqueue(T value){
        Node oldTail = this.tail;
        this.tail = new Node(value);
        this.N++;
        if(this.head == null){
            this.head = this.tail;
            return;
        }
        oldTail.next = this.tail;
    }

    public T dequeue(){
        if(this.head == null){
            return null;
        }
        T value = this.head.value;
        this.head = this.head.next;
        this.N--;
        if(this.head == null){
            this.tail = null;
        }
        return value;
    }

    // 实现Iterator
    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T>{
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

}
