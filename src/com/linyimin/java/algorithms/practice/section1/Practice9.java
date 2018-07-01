package com.linyimin.java.algorithms.chapter1.section1;

import algs4.cs.princeton.edu.StdOut;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 17:23 2018/6/24
 */
public class Practice9 {
    /**
     *      18  --> 10010
     * @param args
     */
    public static void main(String [] args){
        int N = 18;
        String s = "";
        for(N = 18; N > 0; N = N /2){
            s = N % 2 + s;
        }

        StdOut.println(s);
        StdOut.println(Integer.toBinaryString(18));
    }
}
