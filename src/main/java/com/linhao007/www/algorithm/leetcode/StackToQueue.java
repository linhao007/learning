package com.linhao007.www.algorithm.leetcode;


import java.util.Queue;
import java.util.Stack;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/1 19:46
 * @description:
 */
public class StackToQueue {
    /**
     * 入栈的栈
     */
    private Stack<Integer> s1;

    /**
     * 出栈的栈
     */
    private Stack<Integer> s2;

    public StackToQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void offer(int x) {
        s1.push(x);
        while (!s2.empty()) {
            s1.push(s2.pop());
        }

        // 交换a和b,使得a队列没有在push()的时候始终为空队列
        Stack temp = s1;
        s1 = s2;
        s2 = temp;
    }

    public int poll() {
        return s2.pop();
    }

}
