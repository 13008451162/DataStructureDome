package com.example.datastructure.List;
/*
 *项目名: DataStructure
 *文件名: LeetCode
 *创建者: SWY
 *创建时间:2023/10/26 下午9:46
 *描述: 141. 环形链表
        简单
        给你一个链表的头节点 head ，判断链表中是否有环。

        如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
        为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
        注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
        如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 */

public class LeetCode141 {

    /**
     * 使用了弗洛伊德判环算法，快指针和慢指针相遇则必有环，否则无环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;

        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;

            //相遇则表示有环
            if (quick == slow) {
                return true;
            }

        }

        return false;
    }
}
