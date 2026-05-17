package io.github.gamelmw.video.queue.priorityqueue;

/*
 * 无序数组实现优先级队列
 * 插入时：直接添加到数组末尾：O(1)
 * 删除/查看时：遍历数组找到最大优先级元素：O(n)
 * */

import io.github.gamelmw.video.queue.Queue;

import java.util.Iterator;

public class PriorityQueue1<E extends Priority> implements Queue<E>, Iterable<E> {
    Priority[] array;
    int size;

    public PriorityQueue1(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E e) {
        if (isFull()) {
            return false;
        }
        array[size] = e;
        size++;
        return true;
    }

    //返回优先级最大的索引值
    private int selectMax() {
        int max = 0;
        for (int i = 1; i < size; i++) {
            if (array[i].priority() > array[max].priority()) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        int max = selectMax();
        E value = (E) array[max];
        remove(max);
        return value;
    }

    private void remove(int index) {
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
        array[size] = null;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        int max = selectMax();
        return (E) array[max];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int p = size - 1;

            @Override
            public boolean hasNext() {
                return p >= 0;
            }

            @Override
            public E next() {
                E value = (E) array[p];
                p--;
                return value;
            }
        };
    }
}
