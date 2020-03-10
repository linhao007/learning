package com.linhao007.www.algorithm.leetcode;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/10 17:39
 * @description: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class IntegerReverse {

    public static int reverse(int x) {
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }

    public static void main(String[] args) {
        System.out.println(reverse(321));
    }
}
