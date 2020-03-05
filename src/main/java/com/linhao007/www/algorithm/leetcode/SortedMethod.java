package com.linhao007.www.algorithm.leetcode;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/2 21:50
 * @description:  奇数对奇数   偶数对偶数位置存放
 */
public class SortedMethod {
    public static int[] sorted(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int j = i + 1;
            //奇数位置
            if (i % 2 != 0) {
                //不是奇数
                if ((array[i] & 0x01) == 0) {
                    while (j < length) {
                        // 奇数位置放置的是奇数，继续往后遍历
                        if ((j & 0x01) == 0 && (array[j] & 0x01) == 1) {
                            j++;
                        } else {
                            // 如果是偶数继续往后遍历
                            if ((array[j] & 0x01) == 0) {
                                j++;
                            } else {
                                break;// 找到奇数
                            }
                        }
                    }
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            } else {// 表示偶数位置
                //不是偶数
                if ((array[i] & 0x01) == 1) {
                    while (j < length) {
                        if ((j & 0x01) == 1 && (array[j] & 0x01) == 0) {
                            j++;
                        } else {
                            if ((array[j] & 0x01) == 1) {
                                j++;
                            } else {
                                break;
                            }
                        }
                    }
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 1, 8, 3, 5, 9, 4};
        System.out.println(sorted(a));
    }
}
