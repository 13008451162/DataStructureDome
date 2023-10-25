package com.example.datastructure.Recursion;
/*
 *项目名: DataStructure
 *文件名: bubble
 *创建者: SWY
 *创建时间:2023/10/24 下午5:38
 *描述: 使用递归实现冒泡
 */

public class bubble {
    public static void main(String[] args) {
        int a[] = {1, 5, 7, 2, 0, 3, 6};
        Bubble(a, a.length - 1);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void Bubble(int[] a, int len) {
        if (len == 0) return;

        for (int i = 0; i < len; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }

        Bubble(a, len - 1);
    }
}
