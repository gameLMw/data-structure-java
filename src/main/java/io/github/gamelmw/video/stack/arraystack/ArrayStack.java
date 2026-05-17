package io.github.gamelmw.video.stack.arraystack;

import io.github.gamelmw.video.stack.Stack;

import java.util.Iterator;

/*
 * 数组实现栈
 * */

public class ArrayStack<E> implements Stack<E>, Iterable<E> {
    private final E[] array;
    private int top = 0;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E e) {
        if (isFull()) {
            return false;
        }
        array[top] = e;
        top++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        top--;
        E value = array[top];
        array[top] = null;

        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int p = top;

            @Override
            public boolean hasNext() {
                return p > 0;
            }

            @Override
            public E next() {
                E value = array[p - 1];
                p--;
                return value;
            }
        };
    }
}
