package com.example.datastructure.Tree;
/*
 *项目名: DataStructure
 *文件名: LeetCode107
 *创建者: SWY
 *创建时间:2023/10/27 下午12:57
 *描述: 107. 二叉树的层序遍历 II
    中等
    给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LeetCode107 {
    public static void main(String[] args) {
        //创建一颗树
        TreeNode root = TreeNode.makeTree();

        System.out.println(levelOrder(root));
    }

    /**
     * 使用栈和队列的方法遍历一个二叉树，队列用于遍历，栈用于存储。最终结果出栈就形成一个逆向的层序遍历
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> list = new Stack<>();
        queue.add(root);
        int n = 1;

        //判断传入空的情况
        if (root == null) {
            return list;
        }

        while (!queue.isEmpty()) {
            int k = 0;
            List<Integer> listsun = new LinkedList<>();
            //添加每一层的数据
            for (int i = 0; i < n; i++) {
                TreeNode tree = queue.poll();
                listsun.add(tree.val);
                if (tree.left != null) {
                    queue.add(tree.left);
                    k++;
                }
                if (tree.right != null) {
                    queue.add(tree.right);
                    k++;
                }
            }
            n = k;
            list.add(listsun);
        }

        List<List<Integer>> newlist = new LinkedList<>();
        while (!list.isEmpty()){
            newlist.add(list.pop());
        }

        return newlist;
    }
}
