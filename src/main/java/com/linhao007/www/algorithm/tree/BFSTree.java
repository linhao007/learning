package com.linhao007.www.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
     * 二叉树的反转
     */

    public static TreeNode convertNode(TreeNode root) {

        return root;
    }


    /**
     * Z型遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        int depth = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = null;
                //因为是走z字形，所有相邻两层的节点处理是相反的
                if (depth % 2 == 0) {
                    //获取链表最后一个节点
                    node = queue.pollLast();
                    if (node.left != null) {
                        queue.offerFirst(node.left);
                    }
                    if (node.right != null) {
                        queue.offerFirst(node.right);
                    }

                } else {
                    //获取链表第一个节点
                    node = queue.poll();
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                }
                tmp.add(node.val);
            }
            depth++;
            result.add(tmp);
        }
        return result;
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

    /**
     * 将一个二叉树转换成较大值的二叉树
     *
     * @param root
     * @return
     */
    int sum;

    public TreeNode convertBST(TreeNode root) {
        convertBST_02(root);
        return root;
    }

    private void convertBST_02(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        convertBST_02(treeNode.right);
        treeNode.val += sum;
        sum = treeNode.val;
        convertBST_02(treeNode.left);
    }


}
