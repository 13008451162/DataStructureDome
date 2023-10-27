package com.example.datastructure.Tree;
/*
 *项目名: DataStructure
 *文件名: LevelOrderBinaryTree
 *创建者: SWY
 *创建时间:2023/10/27 上午11:45
 *描述: 二叉树的层序遍历法
 */

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderBinaryTree {
    public static void main(String[] args) {

        //创建一颗树
        TreeNode root = TreeNode.makeTree();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        //使用队列遍历
        while (!queue.isEmpty()){
            TreeNode n = queue.poll();
            System.out.println(n.val);
            if (n.left != null){
                queue.add(n.left);
            }
            if (n.right != null){
                queue.add(n.right);
            }
        }

    }
}
