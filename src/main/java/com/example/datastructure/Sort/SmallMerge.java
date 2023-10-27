package com.example.datastructure.Sort;
/*
 *项目名: DataStructure
 *文件名: SmallMerge
 *创建者: SWY
 *创建时间:2023/10/27 上午8:55
 *描述: 使用归并排序的思想，将数组两个区间内的元素合并。
 * 例如：[1,5,6,2,4,10,11]
 */

import java.util.Arrays;

public class SmallMerge {

    public static void main(String[] args) {
        int a[] = {1, 5, 6, 2, 4, 10, 11};
        int[] k = new int[a.length];
        merge(a, 0, 2, 3, 6, k, 0);
        System.out.println(Arrays.toString(k));

    }

    public static void merge(int[] a1, int i, int iEnd, int j, int jEnd, int[] a2, int k) {

        if (i > iEnd) {
            System.arraycopy(a1, j, a2, k, jEnd - j + 1);
            return;
        } else if (j > jEnd) {
            System.arraycopy(a1, i, a2, k, iEnd - i + 1);
            return;
        }

        if (a1[i] < a1[j]) {
            a2[k] = a1[i];
            merge(a1, i + 1, iEnd, j, jEnd, a2, k + 1);
        } else {
            a2[k] = a1[j];
            merge(a1, i, iEnd, j + 1, jEnd, a2, k + 1);
        }

    }
}
