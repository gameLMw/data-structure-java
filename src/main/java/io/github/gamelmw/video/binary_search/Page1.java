package io.github.gamelmw.video.binary_search;

/*
 * 二分查找(第一版）
 * 数组必须有序
 * 时间复杂度O(logn)
 *
 * 找数，返回索引，找不到返回-1
 * */

public class Page1 {
    public static int binarySearch(int[] arr, int target) {
        //arr为要查找的数组，target为要查找的数
        int left = 0;
        int right = arr.length - 1;
        int num = 0;

        while (left <= right) {

            num++;

            int m = (left + right) / 2;
            if (arr[m] == target) {
                System.out.println("num:" + num);
                return m;
            } else if (target > arr[m]) {
                left = m + 1;
            } else if (target < arr[m]) {
                right = m - 1;
            }
        }
        System.out.println("num:" + num);
        return -1;
    }
}
