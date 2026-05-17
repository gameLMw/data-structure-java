package io.github.gamelmw.video.binary_search;

public class Page2pro {
    public static int binarySearch(int[] arr, int target) {
        return binarySearchHelper(arr, target, 0, arr.length);
    }

    private static int binarySearchHelper(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int m = (left + right) / 2;
        int result = 0;

        if (arr[m] == target) {
            result = m;
        } else if (target > arr[m]) {
            result = binarySearchHelper(arr, target, m + 1, right);
        } else if (target < arr[m]) {
            result = binarySearchHelper(arr, target, left, m);
        }
        return result;
    }
}
