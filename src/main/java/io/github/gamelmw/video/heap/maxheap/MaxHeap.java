package io.github.gamelmw.video.heap.maxheap;

/*
 * 大顶堆
 * */

public class MaxHeap {
    int[] array;
    int size;

    public MaxHeap(int capacity) {
        this.array = new int[capacity];
    }

    //建堆
    public void heapify(int[] array) {
        //如何找到最后一个非叶子节点     size/2-1(size指的是堆中元素个数)
        for (int i = size / 2 - 1; i >= 0; i--) {

        }
    }

    //删除堆顶元素
    public int poll() {
        return 0;
    }

    //删除指定索引元素
    //index指的是堆中的索引
    public int poll(int index) {
        return 0;
    }

    //获取堆顶元素
    public int peek() {
        return 0;
    }

    //堆的尾部添加元素
    public boolean offer(int offered) {
        return true;
    }

    //将inserted 元素上浮：直至offered 小于父元素或到堆顶
    private void up(int offered) {
    }

    //将parent索引处的元素下潜：与两个孩子较大者交换，直至没孩子或孩子没它大
    private void down(int parent) {
    }

    //交换两个索引处的元素
    private void swap(int i, int j) {
    }

}
