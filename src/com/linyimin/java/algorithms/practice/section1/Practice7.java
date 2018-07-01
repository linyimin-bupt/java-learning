package com.linyimin.java.algorithms.chapter1.section1;

import algs4.cs.princeton.edu.StdOut;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 17:05 2018/6/24
 */
public class Practice7 {
    /**
     *      a   3.00009
     *      b   499500
     *      c   10 * N
     */

    public static void main(String [] args){
        double t = 9.0;
        while (Math.abs(t - 9.0/t) > .001)
            t = (9.0/t + t) / 2.0;
        StdOut.printf("%.5f\n", t);

        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);

        sum = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < 10; j++)
                sum++;
        StdOut.println(sum);


    }
}
