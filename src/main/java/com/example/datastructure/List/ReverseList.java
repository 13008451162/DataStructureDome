package com.example.datastructure.List;
/*
 *项目名: DataStructure
 *文件名: ReverseList
 *创建者: SWY
 *创建时间:2023/10/25 下午12:28
 *描述: 反转链表的5种实现方式
 * 206. 反转链表
 */

import static com.example.datastructure.List.ListNode.makeEndList;

public class ReverseList {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        ListNode head = makeEndList(a);
        System.out.println(reverseList4(head));
    }

    /**
     * 创建一个新的链表并且进行反转（使用头插法）
     *
     * @param head 待反转链表
     * @return 反转后的新头节点
     */
    public static ListNode reverseList1(ListNode head) {
        ListNode newHead = null;

        while (head != null) {
            newHead = new ListNode(head.val, newHead);
            head = head.next;
        }
        return newHead;
    }


    /**
     * 递归实现反转链表，在同一个链表上反转
     *
     * @param head 待反转链表
     * @return 反转后的新头节点
     */
    public static ListNode reverseList2(ListNode head) {

        //递归结束条件
        if (head == null || head.next == null) {
            return head;
        }

        ListNode list = reverseList2(head.next);

        //操作链表进行反转
        head.next.next = head;
        head.next = null;

        System.out.println(list);
        return list;
    }


    /**
     * 使用三指针的方法原地反转链表
     *
     * @param head 待反转链表
     * @return 反转后的新头节点
     */
    public static ListNode reverseList3(ListNode head) {
        ListNode newHead = head;
        ListNode head1 = head.next;

        while (head1 != null) {
            head.next = head1.next;
            head1.next = newHead;
            newHead = head1;
            head1 = head.next;
        }

        return newHead;

    }

    /**
     * 使用三指针的方法拆分链表，进行反转
     *
     * @param head
     * @return
     */
    public static ListNode reverseList4(ListNode head) {

        ListNode newHead = null;
        ListNode head1;

        while (head != null) {
            head1 = head.next;
            head.next = newHead;
            newHead = head;
            head = head1;
        }
        return newHead;
    }


}
