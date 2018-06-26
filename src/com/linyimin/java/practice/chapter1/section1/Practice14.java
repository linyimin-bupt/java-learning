package com.linyimin.java.practice.chapter1.section1;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 21:27 2018/6/25
 */
public class Practice14 {
    public static void main(String[] args){
        System.out.println(lg(10000));
    }

    public static int lg(int N){
        for(int i = 0; i < N; i++){

            if((1 << i) > N){
                return --i;
            }
        }
        return -1;
    }
}
