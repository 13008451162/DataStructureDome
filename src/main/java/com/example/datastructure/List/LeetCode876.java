package com.example.datastructure.List;
/*
 *项目名: DataStructure
 *文件名: LeetCode876
 *创建者: SWY
 *创建时间:2023/10/26 下午8:46
 *描述: 876. 链表的中间结点
        简单
        给你单链表的头结点 head ，请你找出并返回链表的中间结点。
        如果有两个中间结点，则返回第二个中间结点。
 */

import static com.example.datastructure.List.ListNode.makeEndList;

public class LeetCode876 {

    public static void main(String[] args) {
        int[] a = {1, 1,4,6,7,8};
        ListNode head = makeEndList(a);
        System.out.println(middleNode(head));
    }

    /**
     * 使用快慢指针的方法实现
     *
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;

        while(quick != null  && quick.next != null){
            slow = slow.next;
            quick = quick.next.next;
        }

        return slow;
    }
}
