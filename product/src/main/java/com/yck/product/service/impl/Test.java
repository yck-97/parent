package com.yck.product.service.impl;

/**
 * 描述
 * Author：yangchangkui
 * Date: 2023/10/21
 */
public class Test {
    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    private static void test3() {
        int[][] source = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] dp = new int[source.length+1][source[0].length+1];
        dp[0][0] = 0;
        for (int i = 1; i < source[0].length; i++) {
            dp[0][i + 1] = source[0][i] + source[0][i-1];
        }
        for (int i = 1; i < source.length; i++) {
            dp[i+1][0] = source[i][0] + source[i-1][0];
        }
        for (int i = 1; i <= source.length; i++) {
            int[] ints = source[i-1];
            for (int j = 1; j <= ints.length; j++) {
                dp[i][j] = source[i-1][j-1] + Math.min(dp[i][j-1], dp[i-1][j]);
            }
        }
        System.out.println(dp[source.length][source[0].length]);
    }

    private static void test2() {
        int[][] dp = new int[7 + 1][3 + 1];
        dp[0][0] = 0;
        dp[1][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i <=7; i++) {
            for (int j = 1; j <= 3; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        System.out.println(dp[7][3]);
    }

    private static void test1() {
        int n = 3;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
    }

    
}
