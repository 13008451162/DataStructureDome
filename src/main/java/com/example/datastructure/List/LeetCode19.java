package com.example.datastructure.List;
/*
 *项目名: DataStructure
 *文件名: LeetCode19
 *创建者: SWY
 *创建时间:2023/10/25 下午7:07
 *描述: 19. 删除链表的倒数第 N 个结点
    给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */

import static com.example.datastructure.List.ListNode.makeEndList;

public class LeetCode19 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        ListNode head = makeEndList(a);
        System.out.println(removeNthFromEnd1(head,2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //使用一个哨兵处理删除正数第一个的情况
        ListNode dummyHead = new ListNode(-1,head);

        recursion(dummyHead,n);
        return dummyHead.next;
    }

    public static int recursion(ListNode head, int n){
        if(head == null){
            return 0;
        }

        int nth = recursion(head.next,n);//下一个节点的位置

        if (nth == n){
            //判断出下一个节点的的位置刚好是需要被删除的节点
            head.next = head.next.next;
        }

        return nth+1;   //当前节点的位置
    }

    /**
     * 使用快慢指针的方法
     *
     * @param head  待删除链表
     * @param n   倒数第n个节点
     * @return
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        //使用一个哨兵处理删除正数第一个的情况
        ListNode dummyHead = new ListNode(-1,head);
        ListNode slow = dummyHead;
        ListNode quick = dummyHead;

        for (int i = 0; i < n; i++) {
            slow = slow.next;
        }

        while (slow.next != null){
            slow = slow.next;
            quick = quick.next;
        }

        quick.next = quick.next.next;

        return dummyHead.next;
    }

}
