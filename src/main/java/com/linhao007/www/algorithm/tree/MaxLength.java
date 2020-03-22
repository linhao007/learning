package com.linhao007.www.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/17 18:44
 * @description:
 */
public class MaxLength {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    public static int maxLength_01(TreeNode root) {
        //记录最左编号
        List<Integer> lefts = new ArrayList<Integer>();

        //接受宽度参数
        int[] res = new int[1];

        maxLength(root, 1, 0, lefts, res);
        return res[0];
    }

    /**
     * 计算最大宽度
     假设满二叉树表示成数组序列, 根节点所在的位置为1, 则任意位于i节点的左右子节点的index为2*i, 2*i+1
     用一个List保存每层的左端点, 易知二叉树有多少层List的元素就有多少个. 那么可以在dfs的过程中记录每个
     节点的index及其所在的层level, 如果level > List.size()说明当前节点就是新的一层的最左节点, 将其
     加入List中, 否则判断当前节点的index减去List中对应层的最左节点的index的宽度是否大于最大宽度并更新
     * @return
     */
    public static void maxLength(TreeNode node, int id, int depth, List<Integer> lefts, int[] res) {
        if (node == null) {
            return;
        }

        if (depth >= lefts.size()) {
            lefts.add(id);
        }
        res[0] = Math.max(res[0], id + 1 - lefts.get(depth));
        maxLength(node.getLeft(), id * 2, depth + 1, lefts, res);
        maxLength(node.getRight(), id * 2 + 1, depth + 1, lefts, res);

    }


    public static void main(String[] args) {
        TreeNode node_01 = new TreeNode(1);

        TreeNode node_02 = new TreeNode(2);
        TreeNode node_03 = new TreeNode(3);
        TreeNode node_04 = new TreeNode(4);
        TreeNode node_05 = new TreeNode(5);
        TreeNode node_06 = new TreeNode(6);

        node_01.setLeft(node_02);
        node_01.setRight(node_03);

        node_02.setLeft(node_04);
        node_02.setRight(node_05);

        node_03.setRight(node_06);

        System.out.println(maxLength_01(node_01));

    }
}
