package com.linhao007.www.algorithm.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/2/25 17:44
 * @description: 1、对于不为空的结点，先把该节点加入到队列中
 * 2、从队列中拿出结点，如果该节点的左右节点不为空，就分别把左右节点加入到队列中
 * 3、重复以上操作直到队列为空
 */
public class BFSTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 层次遍历
     *
     * @param root
     */
    public static void laywerTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        TreeNode currentNode;
        while (!list.isEmpty()) {
            currentNode = list.poll();
            System.out.println(currentNode.val);
            if (currentNode.left != null) {
                list.add(currentNode.left);
            }
            if (currentNode.right != null) {
                list.add(currentNode.right);
            }
        }
    }

    /**
     * 前序遍历  递归实现 先根节点 再左子树 最后右子树
     *
     * @param root
     */
    public static void preOrderTraversel(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrderTraversel(root.left);
            preOrderTraversel(root.right);
        }
    }


    /**
     * 前序遍历 非递归
     *
     * @param root
     */
    public void preOrderTraversel_01(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                System.out.println(node.val);
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tem = stack.pop();
                node = tem.right;
            }
        }
    }

    /**
     * 中序遍历  顺序：先左子树  再根节点 最后右子树
     *
     * @param root
     */
    public static void inOrderTraverse(TreeNode root) {
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.println(root.val);
            inOrderTraverse(root.right);
        }
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void inOrderTraverse_01(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tem = stack.pop();
                System.out.println(node.val);
                node = tem.right;
            }
        }
    }


    /**
     * 后序遍历  顺序：先左子树  再右子树 最后根节点
     *
     * @param root
     */
    public static void postOrderTraverse(TreeNode root) {
        if (root != null) {
            postOrderTraverse(root.right);
            postOrderTraverse(root.left);
            System.out.println(root.val);
        }
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public void postOrderTraverse_01(TreeNode root) {
        TreeNode cur, pre = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            cur = stack.peek();
            if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
                System.out.println(cur.val);
                stack.pop();
                pre = cur;
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
    }


}
