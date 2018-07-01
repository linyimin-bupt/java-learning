package com.linyimin.java.algorithms.chapter1.section1;

import algs4.cs.princeton.edu.StdOut;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 17:00 2018/6/24
 */
public class Practice6 {
    /**
     * 0
     * 1
     * 1
     * 2
     * 3
     * 5
     * 8
     * 13
     * 21
     * 34
     * 55
     * 89
     * ......
     * @param args
     */
    public static void main(String [] args){
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++)
        {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }
}
