package com.example.datastructure.Stack;
/*
 *项目名: DataStructure
 *文件名: InfixToSuffix
 *创建者: SWY
 *创建时间:2023/10/28 下午1:37
 *描述: 中缀表达式转后缀表达式的计算
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InfixToSuffix {
    public static void main(String[] args) {
        String str = infixToSuffix("(3+2)*2").toString();

        System.out.println(str);

        String[] strArrays = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            strArrays[i] = String.valueOf(str.charAt(i));
        }
        System.out.println(LeetCode150.evalRPN(strArrays));
    }

    /**
     * 中缀转后缀 —— 将运算符放入栈中。
     * @param str
     * @return
     */
    public static StringBuilder infixToSuffix(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder(str.length());

        for (int i = 0; i < str.length(); i++) {
            char n = str.charAt(i);
            switch (n) {
                case '+', '-', '*', '/' -> {
                    if (!stack.isEmpty()) {
                        //栈顶元素优先级大于等于比较元素则出栈，结束后比较元素入栈
                        while (!stack.isEmpty() && priority(stack.peek()) >= priority(n)) {
                            builder.append(stack.pop());
                        }
                        stack.push(n);

                    } else {
                        stack.push(n);
                    }
                }

                case '(' -> stack.push(n);

                case ')' -> {
                    while (!stack.isEmpty() && stack.peek() != '('){
                        builder.append(stack.pop());
                    }
                    //抛出左括号 "("
                    stack.pop();
                }

                default -> builder.append(n);
            }
        }

        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }


        return builder;

    }

    /**
     * 判断符号的优先级
     *
     * @param c
     * @return
     */
    public static int priority(char c) {
        switch (c) {
            case '+', '-' -> {
                return 1;
            }
            case '*', '/' -> {
                return 2;
            }

            case '(' ->{
                return 0;
            }

            default -> throw new RuntimeException("错误的表达式: " + c);
        }
    }
}
