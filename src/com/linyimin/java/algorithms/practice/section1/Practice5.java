package com.linyimin.java.algorithms.practice.section1;

import algs4.cs.princeton.edu.StdOut;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 16:52 2018/6/24
 */
public class Practice5 {
    public static void main(String [] args){
        double x = 0.000002;
        double y = 0.999999;
        if(x > 0 && (1.0 - x) > 1.0e-12 && y > 0 && (1.0 - y) > 1.0e-12){
            StdOut.println(true);
        }else{
            StdOut.println(false);
        }
    }
}
