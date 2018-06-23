package com.linyimin.java.algorithms.queue;

import com.linyimin.java.algorithms.stack.LinkedListStack;

import java.util.Iterator;
import java.util.Scanner;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 14:22 2018/6/23
 */
public class Test {
    public static void main(String [] args){
        // 测试链表实现的队列
        LinkedListQueue<Double> queue = new LinkedListQueue<>();
        Scanner sin = new Scanner(System.in);
        while(sin.hasNext()){
            double s = sin.nextDouble();
            queue.enqueue(s);
        }
        System.out.println("size=" + queue.size());
        System.out.println(queue.dequeue());
        System.out.println("size=" + queue.size());
        Iterator<Double> iterator = queue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("size=" + queue.size());

    }
}
