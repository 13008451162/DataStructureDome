package com.example.datastructure.Stack;
/*
 *项目名: DataStructure
 *文件名: LeetCode150
 *创建者: SWY
 *创建时间:2023/10/27 下午4:48
 *描述: 150. 逆波兰表达式求值
        中等

        给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
        请你计算该表达式。返回一个表示表达式值的整数。

        注意：
        有效的算符为 '+'、'-'、'*' 和 '/' 。
        每个操作数（运算对象）都可以是一个整数或者另一个表达式。
        两个整数之间的除法总是 向零截断 。
        表达式中不含除零运算。
        输入是一个根据逆波兰表示法表示的算术表达式。
        答案及所有中间计算结果可以用 32 位 整数表示。
 */

import java.util.Stack;

public class LeetCode150 {

    public static void main(String[] args) {
        String[] a = {"4","13","5","/","+"};
        System.out.println(evalRPN(a));
    }

    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String t : tokens) {

            switch (t){
                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;
                case "-":
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(b-a);
                    break;
                case "*":
                    stack.push(stack.pop()*stack.pop());
                    break;
                case "/":
                    Integer a1 = stack.pop();
                    Integer b1 = stack.pop();
                    stack.push(b1/a1);
                    break;
                default:
                    stack.push(Integer.valueOf(t));
            }
        }

        return stack.pop();
    }
}
