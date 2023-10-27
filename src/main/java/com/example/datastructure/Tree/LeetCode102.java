package com.example.datastructure.Tree;
/*
 *项目名: DataStructure
 *文件名: LeetCode102
 *创建者: SWY
 *创建时间:2023/10/27 下午12:20
 *描述: 102. 二叉树的层序遍历
        中等
        给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LeetCode102 {
    public static void main(String[] args) {
        //创建一颗树
        TreeNode root = TreeNode.makeTree();

        System.out.println(levelOrder(root));
    }

    /**
     * 使用队列的方法层序遍历一个二叉树，保证其正向输出
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new LinkedList<>();
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

        return list;
    }
}
