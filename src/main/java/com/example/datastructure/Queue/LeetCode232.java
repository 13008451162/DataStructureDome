package com.example.datastructure.Queue;
/*
 *项目名: DataStructure
 *文件名: MyQueue
 *创建者: SWY
 *创建时间:2023/10/28 下午4:28
 *描述: 232. 用栈实现队列
        简单
        实现 MyQueue 类：

        void push(int x) 将元素 x 推到队列的末尾
        int pop() 从队列的开头移除并返回元素
        int peek() 返回队列开头的元素
        boolean empty() 如果队列为空，返回 true ；否则，返回 false
 */

import java.util.Stack;

class LeetCode232 {

    public static Stack<Integer> stack1 = new Stack<>();
    public static Stack<Integer> stack2 = new Stack<>();

    public LeetCode232() {

    }

    public void push(int x) {
        stack2.empty();
        while (stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack2.push(x);
    }

    public int pop() {
        stack1.empty();
        while (stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return stack1.pop();
    }

    public int peek() {
        stack1.empty();
        while (stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return stack1.peek();
    }

    public boolean empty() {
        return (stack1.isEmpty() && stack2.isEmpty()) ? true : false;
    }
}
