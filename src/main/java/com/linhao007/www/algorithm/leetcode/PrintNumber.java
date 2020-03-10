package com.linhao007.www.algorithm.leetcode;


/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/6 15:09
 * @description: 约瑟夫环 编号1-100的人员 围成一个圈  一次报数  报道3的时候  就退出  然后再重新报数
 */
public class PrintNumber {

    public static void main(String[] args) {
        //假设一共有100个人，同时也是数组容量
        int number = 100;

        //定义数组下标
        int index = 0;

        //报数
        int say = 0;

        //定义一个boolean类型的数组，将所有人装进去，数组元素默认为ture。
        boolean array[] = new boolean[number];

        //当该座位的人报数为3时，将该数组元素从ture改成false。从而实现人数减1
        for (int i = 0; i < array.length; i++) {
            array[i] = true;
        }

        //当只剩一个人的时候，跳出循环
        while (number > 1) {

            //座位有人时报数
            if (array[index]) {
                //报数
                say++;
            }

            //当报数为三时，重新开始计数，该座位的人离开，数组位置值变为false,人数减一
            if (say == 3) {
                say = 0;
                array[index] = false;
                number--;
            }

            //数组下标加一，往后移动，继续报数
            index++;

            //当数组下标等于100的时候，重新开始一圈，数组下标变为0
            if (index == 100) {
                index = 0;
            }
        }

        //进行多次循环后，找出最后数组中值仍然为ture的元素
        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                System.out.println("剩下的是从刚开始报数之后的第" + i + "个人");
            }
        }
    }
}
