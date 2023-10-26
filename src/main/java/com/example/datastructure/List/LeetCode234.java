package com.example.datastructure.List;
/*
 *项目名: DataStructure
 *文件名: LeetCode234
 *创建者: SWY
 *创建时间:2023/10/26 下午9:20
 *描述: 234. 回文链表
        简单
        给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */

import static com.example.datastructure.List.ListNode.makeEndList;

public class LeetCode234 {

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1};
        ListNode head = makeEndList(a);
        System.out.println(isPalindrome(head));
    }

    /**
     * 使用递归的方法，先找到中间节点，然后将后半部分使用递归反转，时间复杂度为O(n),空间复杂度也是O(n)
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;

        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }

        ListNode p = resverList(slow);
        System.out.println(p);

        while (p != null) {
            System.out.println("p.val = " + p.val + "  slow.val = " + head.val);
            if (p.val != head.val) {
                return false;
            }

            p = p.next;
            head = head.next;
        }
        return true;
    }

    public static ListNode resverList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //进行递归
        ListNode p = resverList(head.next);

        head.next.next = head;
        head.next = null;

        return p;
    }


    /**
     * 使用三指针的方法，在寻找中间节点的同时反转前一部分链表。时间复杂度为O(n/2)，空间复杂度为O(1)
     *
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // 使用快慢指针找到中点，同时反转前半部分链表
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode temp = slow;
            slow = slow.next;
            temp.next = prev;
            prev = temp;
        }

        // 如果链表长度为奇数，中点处的节点不需要比较，直接跳过
        if (fast != null) {
            slow = slow.next;
        }

        // 比较前半部分链表（prev）和后半部分链表（slow）
        while (prev != null && slow != null) {
            if (prev.val != slow.val) {
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }

        return true;
    }

}
