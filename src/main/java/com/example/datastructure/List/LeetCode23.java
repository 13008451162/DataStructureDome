package com.example.datastructure.List;
/*
 *项目名: DataStructure
 *文件名: LeetCode23
 *创建者: SWY
 *创建时间:2023/10/26 下午6:39
 *描述: 23. 合并 K 个升序链表
        困难
        给你一个链表数组，每个链表都已经按升序排列。

        请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */

public class LeetCode23 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 7};
        int[] b = {2, 3, 6, 9, 13};
        int[] c = {1, 3, 6, 10, 12};
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = ListNode.makeEndList(a);
        listNodes[1] = ListNode.makeEndList(b);
        listNodes[2] = ListNode.makeEndList(c);

        System.out.println(mergeKLists(listNodes));
    }

    /**
     * 合并两个有序链表
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }



    }

    /**
     * 合并K个有序链表
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return split(lists, 0, lists.length-1);
    }

    /**
     * 进行拆分利用分治的思想(类似于快排）
     *
     * @param listNodes
     * @param i 左值
     * @param j 右值
     * @return 返回两个链表合并的结果
     */
    public static ListNode split(ListNode[] listNodes, int i, int j) {

        if(i == j){
            return listNodes[i];
        }

        int t = (i + j) / 2;    //中间值
        ListNode left = split(listNodes,i,t);
        ListNode right = split(listNodes,t+1,j);

        return mergeTwoLists(left,right);
    }

}
