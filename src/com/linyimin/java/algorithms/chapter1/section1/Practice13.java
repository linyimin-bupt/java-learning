package com.linyimin.java.algorithms.chapter1.section1;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 21:16 2018/6/25
 */
public class Practice13 {
    private static int[][] origin = {
            {1, 2, 3},
            {4, 5, 6}
    };
    private static int[][] transposition = new int[3][2];
    public static void main(String args [] ){
        for(int i = 0; i < origin.length; i++){
            for(int j = 0; j < origin[i].length; j++){
                transposition[j][i] = origin[i][j];
            }
        }

        for(int i = 0; i < transposition.length; i++){
            for(int j = 0; j < transposition[i].length; j++){
                System.out.print(transposition[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
