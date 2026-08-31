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

    public MaxHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify(array);
    }

    //获取堆顶元素
    public int peek() {
        if (size == 0) {
            throw new IllegalArgumentException("堆为空");
        }
        return array[0];
    }

    //删除堆顶元素
    public int poll() {
        if (size == 0) {
            throw new IllegalArgumentException("堆为空");
        }
        int top = array[0];
        swap(0, size - 1);
        size--;
        down(0);
        return top;
    }

    //删除指定索引元素
    //index指的是堆中的索引
    public int poll(int index) {
        if (size == 0) {
            throw new IllegalArgumentException("堆为空");
        }
        int deleted = array[index];
        swap(index, size - 1);
        size--;
        down(index);
        return deleted;
    }

    //替换堆顶元素
    //offered指的是要替换的元素
    public void replace(int replaced) {
        if (size == 0) {
            throw new IllegalArgumentException("堆为空");
        }
        array[0] = replaced;
        down(0);
    }

    //堆的尾部添加元素
    public boolean offer(int offered) {
        if (size == array.length) {
            throw new IllegalArgumentException("堆已满");
        }
        up(offered);
        size++;
        return true;
    }

    //将inserted 元素上浮：直至offered 小于父元素或到堆顶
    private void up(int offered) {
        int child = size;
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (offered > array[parent]) {
                array[child] = array[parent];
            } else {
                break;
            }
            child = parent;
        }
        array[child] = offered;
    }

    //建堆
    public void heapify(int[] array) {
        //如何找到最后一个非叶子节点     size/2-1(size指的是堆中元素个数)
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(i);
        }
    }

    //将parent索引处的元素下潜：与两个孩子较大者交换，直至没孩子或孩子没它大
    private void down(int parent) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        int max = parent;
        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }
        if (max != parent) { //找到了更大的孩子
            swap(parent, max);
            down(max);
        }
    }

    //交换两个索引处的元素
    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
