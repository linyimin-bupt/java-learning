package com.linyimin.java.algorithms.theory.bag;

import java.util.Iterator;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 16:57 2018/6/23
 */
public class LinkedListBag<T> implements Iterable<T> {
    private int N;
    private Node head;

    private class Node{
        private T value;
        private Node next;

        public Node(T value){
            this.value = value;
        }
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void add(T value){
        Node oldHead = this.head;
        this.head = new Node(value);
        this.N++;
        this.head.next = oldHead;
    }
    @Override
    public Iterator<T> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<T> {
        private Node current = head;
        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            return value;
        }
    }
}
