package com.example.datastructure.Recursion;
/*
 *项目名: DataStructure
 *文件名: Hanoi
 *创建者: SWY
 *创建时间:2023/10/25 上午11:51
 *描述: 实现汉诺塔
 */

import java.util.LinkedList;

public class Hanoi {

    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        init(5);
        long ebdTime  = System.nanoTime();
        System.out.println("Time = "+ (ebdTime-startTime) +"ns");
        print();
    }

    private static void print() {
        System.out.println("**************************");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    /**
     * 汉诺塔的递归
     * @param n 塔的层数
     * @param a 原
     * @param b 借
     * @param c 目标
     */
    public static void towerOfHanoi(int n,LinkedList<Integer> a
                    ,LinkedList<Integer> b,LinkedList<Integer> c){

        if (n == 0){
            return;
        }

        towerOfHanoi(n-1,a,c,b);
        c.add(a.removeLast());  //将a移动到c
        towerOfHanoi(n-1,b,a,c);

    }

    public static void init(int n){
        for (int i = n; i>=1; i--){
            a.add(i);
        }
        towerOfHanoi(n,a,b,c);
    }
}
