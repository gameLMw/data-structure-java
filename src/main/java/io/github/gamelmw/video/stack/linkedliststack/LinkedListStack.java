package io.github.gamelmw.video.stack.linkedliststack;

import io.github.gamelmw.video.stack.Stack;

import java.util.Iterator;

/*
 * 链表实现�?
 * */

public class LinkedListStack<E> implements Stack<E>, Iterable<E> {

    private static class Node<E> {
        E e;
        Node<E> next;

        public Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }
    }

    private int capacity;
    private int size;
    private Node<E> head = new Node<>(null, null);

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean push(E e) {
        if (isFull()) {
            return false;
        }
        head.next = new Node<>(e, head.next);
        size++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;
        size--;
        return first.e;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.next.e;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> p = head.next;
            private int count = size;

            @Override
            public boolean hasNext() {
                return count > 0;
            }

            @Override
            public E next() {
                E value = p.e;
                p = p.next;
                count--;
                return value;
            }
        };
    }
}
