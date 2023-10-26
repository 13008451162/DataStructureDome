package com.example.datastructure.List;
/*
 *项目名: DataStructure
 *文件名: LeetCode83
 *创建者: SWY
 *创建时间:2023/10/26 上午11:53
 *描述: 83. 删除排序链表中的重复元素
    给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */

import static com.example.datastructure.List.ListNode.makeEndList;

public class LeetCode83 {
    public static void main(String[] args) {
        int[] a = {1,1,2};
        ListNode head = makeEndList(a);
        System.out.println(deleteDuplicates1(head));
    }

    /**
     * 使用双指针的方法
     *
     * @param head 待处理链表
     * @return 处理完成的链表
     */
    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null) return head;

        ListNode quick = head;
        ListNode solw = head.next;


        while (solw != null) {
            if (solw.val == quick.val) {
                quick.next = solw.next;
            } else {
                quick = solw;
            }

            solw = solw.next;
        }
        return head;
    }

    /**
     * 使用递归的方法
     *
     * @param head 待处理链表
     * @return 处理完成的链表
     */
    public static ListNode deleteDuplicates1(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        if (head.val == head.next.val) {
            return deleteDuplicates1(head.next);
        } else {
            head.next = deleteDuplicates1(head.next);
            return head;
        }
    }
}
