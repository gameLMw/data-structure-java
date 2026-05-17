package io.github.gamelmw.video.binary_search;

import org.junit.jupiter.api.Test;

class Page2proTest {
    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i = Page2pro.binarySearch(arr, 2);
        System.out.println(i);
    }

}