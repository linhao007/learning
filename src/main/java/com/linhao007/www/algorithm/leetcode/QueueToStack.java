package com.linhao007.www.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/1 19:43
 * @description:
 */
public class QueueToStack {
    /**
     * 输入队列
     */
    private Queue<Integer> a;
    /**
     * 输出队列
     */
    private Queue<Integer> b;

    public QueueToStack() {
        a = new LinkedList<Integer>();
        b = new LinkedList<Integer>();
    }

    public void push(int x) {
        a.offer(x);
        // 将b队列中元素全部转给a队列
        while (!b.isEmpty()){
            a.offer(b.poll());
        }
        // 交换a和b,使得a队列没有在push()的时候始终为空队列
        Queue temp = a;
        a = b;
        b = temp;
    }

    public int pop() {
        return b.poll();
    }

    public int top() {
        return b.peek();
    }

    public boolean empty() {
        return b.isEmpty();
    }
}
