package io.github.gamelmw.video.queue.priorityqueue;

/*
 * 二叉堆实现优先级队列
 * 插入时：找到合适位置插入，保持数组有序：O(log n)
 * 删除/查看时：直接取数组首或尾元素：O(1)
 * */

import io.github.gamelmw.video.queue.Queue;

import java.util.Iterator;

public class PriorityQueue3<E extends Priority> implements Queue<E>, Iterable<E> {
    Priority[] array;
    int size;

    public PriorityQueue3(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E e) {
        if (isFull()) {
            return false;
        }
        int child = size;
        // FIXME:
        return true;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
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
