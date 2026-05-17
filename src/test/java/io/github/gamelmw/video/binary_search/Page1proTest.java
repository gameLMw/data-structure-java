package io.github.gamelmw.video.binary_search;

import org.junit.jupiter.api.Test;

class Page1proTest {
    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i = Page1pro.binarySearch(arr, 8);
        System.out.println(i);
    }
}