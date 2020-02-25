package com.linhao007.www.algorithm.reverse.list;

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

    public static  Node reverseList(Node head) {
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



}
