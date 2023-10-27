package com.example.datastructure.List;
/*
 *项目名: DataStructure
 *文件名: LeetCode142
 *创建者: SWY
 *创建时间:2023/10/27 上午8:34
 *描述: 142. 环形链表 II
    中等

    给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
    评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。
    注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

    不允许修改链表。


 */

public class LeetCode142 {

    /**
     * 使用判环算法，如果找到环以后。快指针位置不变，慢指针回到原点，
     * 两个指针每次均移动一次，相遇时就是环型链表的环型入口
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;

        //判断是否有环
        while(quick != null && quick.next != null){
            quick = quick.next.next;
            slow = slow.next;

            if(quick == slow){
                break;
            }
        }

        slow = head;    //慢指针回到开头位置

        //同时移动寻找入口点
        while(quick != null && quick.next != null){

            if(slow == quick){
                return slow;
            }

            quick = quick.next;
            slow = slow.next;
        }

        return null;
    }
}
