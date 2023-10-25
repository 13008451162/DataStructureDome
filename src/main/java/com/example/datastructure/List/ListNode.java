package com.example.datastructure.List;
/*
 *项目名: DataStructure
 *文件名: ListNode
 *创建者: SWY
 *创建时间:2023/10/25 下午12:28
 *描述: 节点类,提供使用链表的基本工具
 */

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    /**
     * 头插法创建链表,最终值是与给定值相反
     *
     * @param values 需要插入的值的int[]数组
     * @return 返回不带虚拟节点的头节点
     */
    public static ListNode makeCreateList(int[] values) {
        ListNode head = new ListNode();
        for (int value : values) {
            head.next = new ListNode(value,head.next);

//            newNode.next = head.next;
//            head.next = newNode;
        }

        return head.next;
    }

    /**
     * 尾插法创建链表,最终值是与给定值相同
     *
     * @param values 需要插入的值的int[]数组
     * @return 返回不带虚拟节点的头节点
     */
    public static ListNode makeEndList(int[] values) {
        ListNode head = new ListNode();
        ListNode nowHead = head;
        for (int value : values){
            ListNode newNode = new ListNode(value);
            nowHead.next = newNode;
            nowHead = newNode;
        }
        return head.next;
    }
}
