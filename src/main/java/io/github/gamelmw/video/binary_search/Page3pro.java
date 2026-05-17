package io.github.gamelmw.video.binary_search;

public class Page3pro {
    public static int binarySearch(int[] arr, int target) {
        return binarySearchHelper(arr, target, 0, arr.length - 1);
    }

    private static int binarySearchHelper(int[] arr, int target, int left, int right) {
        if (right - left <= 1) {
            if (arr[left] == target) {
                return left;
            } else if (arr[right] == target) {
                return right;
            } else {
                return -1;
            }
        }

        int m = (left + right) / 2;

        if (target < arr[m]) {
            return binarySearchHelper(arr, target, left, m);
        } else {
            return binarySearchHelper(arr, target, m, right);
        }
    }
}
