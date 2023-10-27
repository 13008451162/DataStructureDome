package com.example.datastructure.Stack;
/*
 *项目名: DataStructure
 *文件名: StackUsingList
 *创建者: SWY
 *创建时间:2023/10/27 下午2:48
 *描述: 使用链表实现一个队列的基本功能
 */

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class LinkedListStack<E> implements Iterable<E> {

    private final int capacity; //栈的最大容量
    private int size;   //当前数目

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }

    //头节点位置
    private final Node<E> head = new Node<>(null,null);


    static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public E next() {
                E value =p.value;
                p = p.next;

                return value;
            }
        };
    }

    boolean push(E value) {
        if (isFull()){
            return false;
        }

        head.next = new Node<>(value,head.next);
        size++;
        return true;
    }


    E pop() {
        if (isEmpty()){
            return null;
        }

        Node<E> first = head.next;
        head.next = first.next;
        size--;

        return first.value;
    }

    E peek() {
        if (isEmpty()){
            return null;
        }

        return head.next.value;
    }

    //判空
    boolean isEmpty(){
        return head == null;
    }

    //判满
    boolean isFull(){
        return size == capacity;
    }


}
