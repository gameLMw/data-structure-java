package io.github.gamelmw.video.binary_search.Enhanced;

/*
 * 二分查找
 * 找升序数组里重复的数的最小索引，找到的索引，找不到返回-1
 * */

public class Page1 {
    //O(n)
    public static int binarySearch(int[] arr) {
        int i = 0;
        int num = 0;

        while (true) {
            num++;

            if (arr[i] == arr[i + 1]) {
                System.out.println("num:" + num);
                return i;
            } else {
                i++;
            }
        }
    }

    //Leftmost
    //O(log n)
    public static int binarySearchLeftmost(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
//        int candidate = -1;
        while (left <= right) {
            int m = (right + left) / 2;
            if (target <= arr[m]) {
                right = m - 1;
            } else {
                left = m + 1;
            }
        }
        //return candidate;
        //更好的返回值
        return left;
    }

    //Rightmost
    //O(log n)
    public static int binarySearchRightmost(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int m = (right + left) / 2;
            if (target < arr[m]) {
                right = m - 1;
            } else {
                left = m + 1;
            }
        }
        return left - 1;
    }
}
