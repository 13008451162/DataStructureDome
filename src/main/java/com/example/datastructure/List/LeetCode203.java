package com.example.datastructure.List;
/*
 *项目名: DataStructure
 *文件名: LeetCode203
 *创建者: SWY
 *创建时间:2023/10/25 下午6:09
 *描述: 203. 移除链表元素
    简单
    给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */

import static com.example.datastructure.List.ListNode.makeEndList;

public class LeetCode203 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        ListNode head = makeEndList(a);
        System.out.println(removeElements(head,5));
        System.out.println(removeElements1(head,5));
    }

    /**
     * 创建一个虚拟节点的方式
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {

        // 创建一个虚拟头节点，以便在删除头节点时不需要特殊处理
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode current = dummyHead;

        while (current != null && current.next != null){
            if(current.next.val == val){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }

        return dummyHead.next;
    }

    /**
     * 使用递归的方法进行删除指定数据
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements1(ListNode head, int val) {
        if(head == null){
            return null;
        }

        if(head.val == val){
            //如果是删除该节点那么就相当于返回下一个节点的递归结果，
            // 此时上一个节点就会避开当前节点，而去链接下一个节点
            return removeElements1(head.next,val);
        }else {
            //当前节点链接到后面的链表
            head.next = removeElements1(head.next,val);
            return head;
        }

    }
}
