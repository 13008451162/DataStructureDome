package com.example.datastructure.Recursion;
/*
 *项目名: DataStructure
 *文件名: NumberOfPenalties
 *创建者: SWY
 *创建时间:2023/10/25 下午7:43
 *描述: 2698. 求一个整数的惩罚数
    给你一个正整数 n ，请你返回 n 的 惩罚数 。
    n 的 惩罚数 定义为所有满足以下条件 i 的数的平方和：
    1 <= i <= n
    i * i 的十进制表示的字符串可以分割成若干连续子字符串，且这些子字符串对应的整数值之和等于 i 。
 */

public class NumberOfPenalties {

    public static void main(String[] args) {
        System.out.println(punishmentNumber(121));
    }

    public static int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (check(i * i, i)) {
                sum += i * i;
            }
        }
        return sum;
    }

    public static boolean check(int n, int i) {
        if (n == i) {
            return true;
        }

        int k = 10;

        /**
         *   判断数据是否可以进行拆分，可以拆分的条件为：数字应该大于10并且拆分后的尾数应该小于基准数
         *   例如：121与11,可以拆分为1和21，此时n>k符合条件，
         *   但是n%k = 21,大于11,不可能出现这样的情况符合条件
         */
        while (n >= k && n % k <= i) {
            /*
                将拆分后的数据进行比较，例如121拆分为12与1
                此时n/10 = 12,n%k = 1。得到i-(n%k) = 11
                判断出12 + 1 != i
             */
            if (check(n / k, i - (n % k))) {
                return true;
            }

            //依次从个位，百位....开始拆分。
            //例如121,第一次拆分为1,21;第二次为12,1
            k *= 10;
        }
        return false;
    }

}
