package com.example.datastructure.Recursion;
/*
 *项目名: DataStructure
 *文件名: TailRecursion
 *创建者: SWY
 *创建时间:2023/10/24 下午10:05
 *描述: 尾递归——优化递归解决爆栈问题
 */

public class TailRecursion {

    public static void main(String[] args) {
        System.out.println(sum(10000));
    }

    public static long sum(long n){
        if(n == 1){
            return 1;
        }

        return sum(n-1)+sum(n);
    }
}
