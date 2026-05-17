package io.github.gamelmw.video.queue.priorityqueue;

/*
 * 有序数组实现优先级队列
 * 插入时：找到合适位置插入，保持数组有：O(n)
 * 删除/查看时：直接取数组首或尾元素：O(1)
 * */

import io.github.gamelmw.video.queue.Queue;

import java.util.Iterator;

public class PriorityQueue2<E extends Priority> implements Queue<E>, Iterable<E> {
    Priority[] array;
    int size;

    public PriorityQueue2(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E e) {
        if (isFull()) {
            return false;
        }
        insert(e);
        size++;
        return true;
    }

    private void insert(E e) {
        int i = size - 1;
        while (i >= 0 && array[i].priority() > e.priority()) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = e;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = (E) array[size - 1];
        size--;
        array[size] = null;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[size - 1];
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
