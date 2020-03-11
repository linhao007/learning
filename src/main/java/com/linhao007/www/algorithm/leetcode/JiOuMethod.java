package com.linhao007.www.algorithm.leetcode;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/2 21:50
 * @description: 奇数对奇数   偶数对偶数位置存放
 */
public class JiOuMethod {
    private static void modify(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //最左边的偶数下标
        int even = 0;

        //最左边的奇数下标
        int old = 1;

        //不断检查arr的最后一个数，如果是偶数则和even交换，even+=2，如果是奇数则和old交换，old+=2，直到even或者old大于或等于N

        int end = arr.length - 1;
        while (even <= end && old <= end) {
            if ((arr[end] % 2) == 0) {
                swap(arr, end, even);
                even += 2;
            } else {
                swap(arr, end, old);
                old += 2;
            }
        }
    }

    private static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1,2,4,8,6,3,5,7};
        modify(a);
       for (int i=0;i<a.length;i++){
           System.out.println(a[i]);
       }
    }
}
