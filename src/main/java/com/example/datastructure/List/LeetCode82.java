package com.example.datastructure.List;
/*
 *项目名: DataStructure
 *文件名: LeetCode82
 *创建者: SWY
 *创建时间:2023/10/26 下午1:02
 *描述: 82. 删除排序链表中的重复元素 II
        中等
        给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回已排序的链表 。
 */

import static com.example.datastructure.List.ListNode.makeEndList;

public class LeetCode82 {

    public static void main(String[] args) {
        int[] a = {1, 1};
        ListNode head = makeEndList(a);
        System.out.println(deleteDuplicates1(head));
    }

    /**
     * 使用递归的方法
     *
     * @param head 待处理链表
     * @return 处理完成的链表
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val == head.next.val) {

            //如果一直相同则不停移动指针，一直到找到不相同的节点为止
            ListNode t = head.next.next;
            while (t != null && t.val == head.val) {
                t = t.next;
            }

            return deleteDuplicates(t);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

    /**
     * 使用了一个三指针的方法进行去重
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(head.val, head);
        ListNode Q = dummyHead;
        ListNode solw, quick;

        //Q,solw,quick始终相隔一位
        while ((solw = Q.next) != null && (quick = solw.next) != null) {
            if (solw.val == quick.val) {
                while ((quick = quick.next) != null && quick.val == solw.val) ;
                Q.next = quick;
            } else {
                Q = Q.next;
            }
        }
        return dummyHead.next;
    }

}
