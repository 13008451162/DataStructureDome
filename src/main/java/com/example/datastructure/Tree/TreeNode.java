package com.example.datastructure.Tree;
/*
 *项目名: DataStructure
 *文件名: TreeNode
 *创建者: SWY
 *创建时间:2023/10/27 上午11:40
 *描述: 二叉树的层序遍历法
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(TreeNode left, int val, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }


    /**
     * 创建一个固定的树，用于遍历
     *
     * @return
     */
    public static TreeNode makeTree(){
        //创建一颗树
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7))
        );
        return root;
    }

}
