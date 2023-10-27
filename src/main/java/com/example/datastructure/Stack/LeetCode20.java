package com.example.datastructure.Stack;
/*
 *项目名: DataStructure
 *文件名: LeetCode20
 *创建者: SWY
 *创建时间:2023/10/27 下午3:46
 *描述: 20. 有效的括号
        简单
        给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

        有效字符串需满足：

        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        每个右括号都有一个对应的相同类型的左括号。
 */

import java.util.Stack;

public class LeetCode20 {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] arrays = s.toCharArray();
        stack.push(arrays[0]);

        for(int i=1; i<arrays.length; i++){
            if (!stack.isEmpty()){
                if(isV(stack.peek(),arrays[i])){
                    stack.pop();
                }else {
                    stack.push(arrays[i]);
                }
            }else {
                stack.push(arrays[i]);
            }
        }

        return stack.isEmpty();
    }

    public static boolean isV(char a, char b){
        if(a == '(' && b == ')') return true;
        if(a == '{' && b == '}') return true;
        if(a == '[' && b == ']') return true;

        return false;
    }
}
