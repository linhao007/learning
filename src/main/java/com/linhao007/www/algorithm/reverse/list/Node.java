package com.linhao007.www.algorithm.reverse.list;

import com.linhao007.www.algorithm.leetcode.MaxSum;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/2/25 10:02
 * @description:
 */
public class Node<T> {
    /**
     * 数据域
     */
    private T data;

    /**
     * 指针域
     */
    private Node next;

    public Node(T i) {
        this.data = i;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static Node reverseList(Node head) {
        //单链表为空或者只有一个节点 直接返回原单链表
        if (head == null || head.getNext() == null) {
            return head;
        }
        //前一个指针
        Node preNode = null;
        //当前节点
        Node curNode = head;
        //下一个节点
        Node nextNode = null;

        while (curNode != null) {
            //nextNode  指向下一个节点
            nextNode = curNode.getNext();
            //将当前节点next域指向前一个节点
            curNode.setNext(preNode);
            //preNode指针向前一个节点移动
            preNode = curNode;
            //curNode指针向后移动
            curNode = nextNode;
        }
        return preNode;
    }


    /**
     * 连表相加
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
       输出：7 -> 0 -> 8
       原因：342 + 465 = 807
     * @param l1
     * @param l2
     * @return
     */
    public Node addTwoNumbers(Node<Integer> l1, Node<Integer> l2) {
        Node<Integer> root = new Node<Integer>(0);
        Node<Integer> cursor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.data : 0;
            int l2Val = l2 != null ? l2.data : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            Node<Integer> sumNode = new Node<Integer>(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return root.next;
    }

}
