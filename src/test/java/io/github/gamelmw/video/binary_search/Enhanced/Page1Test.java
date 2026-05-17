package io.github.gamelmw.video.binary_search.Enhanced;

import org.junit.jupiter.api.Test;

class Page1Test {
    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 4, 4, 5, 6, 7, 8};
        int i = Page1.binarySearch(arr);
        System.out.println(i);
        System.out.println(arr[i]);
        System.out.println("---------------");
        int i1 = Page1.binarySearchLeftmost(arr, 4);
        System.out.println(i1);
        System.out.println(arr[i1]);
        System.out.println("---------------");
        int i2 = Page1.binarySearchRightmost(arr, 4);
        System.out.println(i2);
        System.out.println(arr[i2]);
    }

}