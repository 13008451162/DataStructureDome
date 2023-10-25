package com.example.datastructure.Recursion;
/*
 *项目名: DataStructure
 *文件名: Fibonacci
 *创建者: SWY
 *创建时间:2023/10/24 下午9:06
 *描述: 递归优化——记忆法——剪枝操作
 */

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        for (int i = 1; i < 30; i++) {
            System.out.println(pruning(i));
        }

    }

    //进行剪枝
    public static int pruning(int n){
        int[] cache = new int[n+1];
        Arrays.fill(cache,-1);
        cache[0] = 0;
        cache[1] = 1;
        return f(n,cache);
    }

    public static int f(int n,int[] cache) {

        if (cache[n] != -1){
            return cache[n];
        }

        cache[n] = f(n - 1,cache) + f(n - 2,cache);

        return cache[n];
    }
}
