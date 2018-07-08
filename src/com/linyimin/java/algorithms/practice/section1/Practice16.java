package com.linyimin.java.algorithms.practice.section1;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 21:50 2018/6/25
 */
public class Practice16 {
    /**
     * 311611422456
     * @param args
     */
    public static void main(String[] args){
        System.out.println(exR1(6));
    }
    public static String exR1(int n)
    {
        if (n <= 0) return "";
        return exR1(n-3) + n + exR1(n-2) + n;
    }

}
