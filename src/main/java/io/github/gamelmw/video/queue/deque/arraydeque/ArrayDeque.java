package io.github.gamelmw.video.queue.deque.arraydeque;

import io.github.gamelmw.video.queue.deque.Deque;

import java.util.Iterator;

/*
 * 数组表实现双端队列
 * FIXME：未实现
 * */

public class ArrayDeque<E> implements Deque<E>, Iterable<E> {
    @Override
    public boolean offerFirst(E e) {
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        return false;
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean ifFull() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
