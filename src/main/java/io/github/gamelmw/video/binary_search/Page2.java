package io.github.gamelmw.video.binary_search;

/*
 * 二分查找（第二版）
 * */

public class Page2 {
    public static int binarySearch(int[] arr, int target) {
        //arr为要查找的数组，target为要查找的数
        int left = 0;
        int right = arr.length;
        int num = 0;

        while (left < right) {

            num++;

            int m = (left + right) / 2;
            if (arr[m] == target) {
                System.out.println("num:" + num);
                return m;
            } else if (target > arr[m]) {
                left = m + 1;
            } else if (target < arr[m]) {
                right = m;
            }
        }
        System.out.println("num:" + num);
        return -1;
    }
}
