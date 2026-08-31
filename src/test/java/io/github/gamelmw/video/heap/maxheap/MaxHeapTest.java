package io.github.gamelmw.video.heap.maxheap;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MaxHeapTest {
    @Test
    public void test() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        MaxHeap maxHeap = new MaxHeap(array);
        System.out.println(Arrays.toString(maxHeap.array));
    }

    @Test
    public void test2() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        MaxHeap maxHeap = new MaxHeap(array);

        System.out.println(Arrays.toString(maxHeap.array));
        System.out.println("-------------");

        maxHeap.offer(8);
        System.out.println(Arrays.toString(maxHeap.array));
    }
}
