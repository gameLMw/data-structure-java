package io.github.gamelmw.video.queue.linkedlistqueue;

/*
 * 链表实现队列
 * */

import io.github.gamelmw.video.queue.Queue;

import java.util.Iterator;


public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {

    private static class Node<E> {
        E value;
        Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head = new Node<>(null, null);
    private Node<E> tail = head;
    private int size;//节点个数
    private int capacity = Integer.MAX_VALUE;//队列容量

    {
        tail.next = head;
    }

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
    }

    public LinkedListQueue() {
    }

    // 入队
    //e: 入队元素
    @Override
    public boolean offer(E e) {
        if (isFull()) {
            return false;
        }
        Node<E> added = new Node<>(e, head);
        tail.next = added;
        tail = added;
        size++;
        return true;
    }

    // 出队
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;
        if (first == tail) {
            tail = head;
        }
        size--;

        return (E) first.value;
    }

    //返回第一个元素
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) head.next.value;
    }

    // 判断队列是否为空
    @Override
    public boolean isEmpty() {
//        Node<E> p = head;
//        while (p != tail) {
//            p = p.next;
//        }
//        return p.next ==  tail;

        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;
            int count = size;

            @Override
            public boolean hasNext() {
                return count > 0;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                count--;
                return value;
            }
        };
    }

    // 判断队列是否已满
    public boolean isFull() {
        return size == capacity;
    }
}
