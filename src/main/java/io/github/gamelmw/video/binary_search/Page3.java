package io.github.gamelmw.video.binary_search;

/*
 * 二分查找（第三版）
 * 1，2，3版中3最快
 * */

public class Page3 {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int num = 0;

        while (1 < right - left) {
            num++;
            int m = (left + right) / 2;
            if (target < arr[m]) {
                right = m;
            } else {
                left = m;
            }
        }
        if (arr[left] == target) {
            System.out.println("num:" + num);
            return left;
        } else {
            System.out.println("num:" + num);
            return -1;
        }
    }
}

