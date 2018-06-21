package com.linyimin.java.algorithms.stack;

import java.util.Scanner;

public class Test {
    public static void main(String [] args){
//        FixedCapacityStackOfString stack = new FixedCapacityStackOfString(10);
//        Scanner sin = new Scanner(System.in);
//        while(sin.hasNext()){
//            String s = sin.next();
//            if(! s.equals("-")){
//                stack.push(s);
//            }else{
//                break;
//            }
//
//        }
//        System.out.println("size=" + stack.size());
//        int len = stack.size();
//        for(int i = 0; i < len; i++){
//            System.out.println(stack.pop());
//        }
//        System.out.println("size=" + stack.size());
//    }
        FixedCapacityStack<Double> stack = new FixedCapacityStack(10);
        Scanner sin = new Scanner(System.in);
        while(sin.hasNext()){
            double s = sin.nextDouble();
            stack.push(s);
        }
        System.out.println("size=" + stack.size());
        int len = stack.size();
        for(int i = 0; i < len; i++){
            System.out.println(stack.pop());
        }
        System.out.println("size=" + stack.size());
    }
}
