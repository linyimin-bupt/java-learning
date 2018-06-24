package com.linyimin.java.practice.chapter1.section1;

import algs4.cs.princeton.edu.StdOut;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 16:48 2018/6/24
 */
public class Practice3 {

    public static void main(String [] args){
        if(args.length == 3){
            int arg1 = Integer.parseInt(args[0]);
            int arg2 = Integer.parseInt(args[1]);
            int arg3 = Integer.parseInt(args[2]);
            if(arg1 == arg2 && arg2 == arg3){
                StdOut.println(true);
            }else{
                StdOut.println(false);
            }
        }else{
            StdOut.println(false);
        }
    }
}
