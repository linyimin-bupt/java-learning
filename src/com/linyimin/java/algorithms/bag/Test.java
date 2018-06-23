package com.linyimin.java.algorithms.bag;

import com.linyimin.java.algorithms.queue.LinkedListQueue;

import java.util.Iterator;
import java.util.Scanner;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 17:04 2018/6/23
 */
public class Test {
    public static void main(String [] args){
        // 测试链表实现的队列
        LinkedListBag<Double> bag = new LinkedListBag<>();
        Scanner sin = new Scanner(System.in);
        while(sin.hasNext()){
            double s = sin.nextDouble();
            bag.add(s);
        }
        System.out.println("size=" + bag.size());
        Iterator<Double> iterator = bag.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("size=" + bag.size());

    }
}
