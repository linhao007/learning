package com.linhao007.www.algorithm.leetcode;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/10 18:11
 * @description:
 */
public class StringToInteger {
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        //游标初始值
        int i = 0;

        //符号位
        int flag = 1;

        //位数
        int num = 0;

        long ret = 0;

        //开头是空格 则进行游标下移
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }

        //判断符号位
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            flag = str.charAt(i) == '+' ? 1 : -1;
            i++;
        }

        //开头是0则进行游标下移
        while (i < str.length() && str.charAt(i) == '0') {
            i++;
        }

        if (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                ret = ret * 10 + str.charAt(i++) - '0';
                num++;
            }
        }
        ret *= flag;

        if (flag == 1 && (ret > Integer.MAX_VALUE || num > 10)) {
            return Integer.MAX_VALUE;
        }

        if (flag == -1 && (ret < Integer.MIN_VALUE || num > 10)) {
            return Integer.MIN_VALUE;

        }
        return (int) ret;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi(".1"));
        System.out.println(Math.abs(-23));
    }
}
