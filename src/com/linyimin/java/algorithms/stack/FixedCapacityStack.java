package com.linyimin.java.algorithms.stack;

public class FixedCapacityStack<T> {
    private T[] a;
    private int N;
    public FixedCapacityStack(int capacity){
        this.a = (T[]) new Object[capacity];
    }
    public void push(T item){
        this.a[this.N++] = item;
    }

    public T pop(){
        return a[--this.N];
    }

    public boolean isEmpty(){
        return this.N == 0;
    }

    public int size(){
        return this.N;
    }
}
