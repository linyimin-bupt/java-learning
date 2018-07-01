package com.linyimin.java.algorithms.chapter1.section1;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 21:41 2018/6/25
 */
public class Practice15 {
    public static void main(String[] args){
        int [] a = {1,2,1,3,1,4,1,5,7,8};
        int[] result = histogram(a, 10);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + "  ");
        }
        System.out.println();
    }

    public static int[] histogram(int[] a, int M){
        int [] result = new int[M];
        for(int i = 0; i < M; i++){
            for(int j = 0; j < a.length; j++){
                if(a[j] == i){
                    result[i]++;
                }
            }
        }
        return result;
    }
}
