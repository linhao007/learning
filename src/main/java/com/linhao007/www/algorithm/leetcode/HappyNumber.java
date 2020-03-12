package com.linhao007.www.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/12 17:33
 * @description:
 */
public class HappyNumber {

    /**
     * 最简单的思路就是切分 然后一个一个比对  存在List中   判断是否出现重复数  有的话  则直接返回false
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        boolean flag = false;

        List<Integer> tempList = new ArrayList<Integer>();
        tempList.add(n);

        while (n != 1) {
            String[] temNumber = String.valueOf(n).split("");
            int tem_n = 0;
            for (int i = 0; i < temNumber.length; i++) {
                tem_n += tem_n + Integer.valueOf(temNumber[i]) * Integer.valueOf(temNumber[i]);
            }
            if (tempList.contains(tem_n)) {
                return false;
            }
            tempList.add(tem_n);
            if (tem_n == 1) {
                return true;
            }

        }
        return flag;
    }

    //快慢指针
    int trans(int n) {
        // 把一个数替换成平方和
        int res = 0;
        while (n != 0) {
            int num = n % 10;
            res += num * num;
            n /= 10;
        }
        return res;
    }

    boolean isHappy_02(int n) {
        // 利用快慢指针思想, 慢指针每次做一次转换, 快指针每次做两次转换
        // 如果出现无限循环, 那么快慢指针一定相遇
        int slow = trans(n), fast = trans(trans(n));
        while (slow != fast) {
            slow = trans(slow);
            fast = trans(trans(fast));
        }
        return slow == 1;
    }

    public static void main(String[] args) {

    }
}
