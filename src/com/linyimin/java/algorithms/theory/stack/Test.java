package com.linyimin.java.algorithms.theory.stack;

import java.util.Iterator;
import java.util.Scanner;

public class Test {
    public static void main(String [] args){
        // 测试指定类型栈
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
        // 测试泛型栈
//        FixedCapacityStack<Double> stack = new FixedCapacityStack(10);
//        Scanner sin = new Scanner(System.in);
//        while(sin.hasNext()){
//            double s = sin.nextDouble();
//            stack.push(s);
//        }
//        System.out.println("size=" + stack.size());
//        int len = stack.size();
//        for(int i = 0; i < len; i++){
//            System.out.println(stack.pop());
//        }
//        System.out.println("size=" + stack.size());
//    }
        // 测试动态栈
//        DynamicalCapacityStack<Double> stack = new DynamicalCapacityStack<>();
//        Scanner sin = new Scanner(System.in);
//        while(sin.hasNext()){
//            double s = sin.nextDouble();
//            stack.push(s);
//            if(stack.size() > 8){
//                System.out.println("增大数组大小");
//            }
//        }
//        System.out.println("size=" + stack.size());
//        int len = stack.size();
//        for(int i = 0; i < len; i++){
//            System.out.println(stack.pop());
//        }
//        System.out.println("size=" + stack.size());
//    }
        // 测试iterator
//        DynamicCapacityStackWithIterable<Double> stack = new DynamicCapacityStackWithIterable<>();
//        Scanner sin = new Scanner(System.in);
//        while(sin.hasNext()){
//            double s = sin.nextDouble();
//            stack.push(s);
//            if(stack.size() > 8){
//                System.out.println("增大数组大小");
//            }
//        }
//        System.out.println("size=" + stack.size());
//        Iterator<Double> iterator = stack.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//        System.out.println("size=" + stack.size());

        // 测试链表实现的栈
        LinkedListStack<Double> stack = new LinkedListStack<>();
        Scanner sin = new Scanner(System.in);
        while(sin.hasNext()){
            double s = sin.nextDouble();
            stack.push(s);
        }
        System.out.println("size=" + stack.size());
        Iterator<Double> iterator = stack.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("size=" + stack.size());

    }
}
