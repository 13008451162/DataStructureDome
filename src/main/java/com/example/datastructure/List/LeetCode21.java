package com.example.datastructure.List;
/*
 *项目名: DataStructure
 *文件名: LeetCode21
 *创建者: SWY
 *创建时间:2023/10/26 下午4:31
 *描述: 21. 合并两个有序链表
        简单
        将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */

import static com.example.datastructure.List.ListNode.makeEndList;

public class LeetCode21 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 7};
        int[] b = {2, 3, 6, 9, 13};
        ListNode list1 = ListNode.makeEndList(a);
        ListNode list2 = ListNode.makeEndList(b);
        System.out.println(mergeTwoLists1(list1, list2));
    }

    /**
     * 使用创建一个新头节点的方法依次比较两个链表进行相加
     *
     * @param list1
     * @param list2
     * @return 返回添加以后的链表
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode();
        ListNode temporaryHead = newHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temporaryHead.next = list1;
                list1 = list1.next;
            } else {
                temporaryHead.next = list2;
                list2 = list2.next;
            }
            temporaryHead = temporaryHead.next;
        }

        if(list1 != null){
            temporaryHead.next = list1;
        }else {
            temporaryHead.next = list2;
        }

        return newHead.next;
    }


    /**
     * 使用递归的方法进行合并链表
     *
     * @param list1
     * @param list2
     * @return 返回添加以后的链表
     */
    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {

        if(list1 == null){
            return list2;
        }else if (list2 == null){
            return list1;
        }

        if(list1.val < list2.val){
            list1.next = mergeTwoLists1(list1.next,list2);
            return list1;
        }else {
            list2.next = mergeTwoLists1(list1,list2.next);
            return list2;
        }

    }

}
