package com.linyimin.java.algorithms.theory.stack;

public class FixedCapacityStackOfString {
    private String[] a;
    private int N;

    public FixedCapacityStackOfString(int n){
        a = new String[n];
    }

    public boolean isEmpty(){
        return this.N == 0;
    }

    public int size(){
        return this.N;
    }

    public void push(String item){
        a[N++] = item;
    }

    public String pop(){
        return a[--N];
    }
}
