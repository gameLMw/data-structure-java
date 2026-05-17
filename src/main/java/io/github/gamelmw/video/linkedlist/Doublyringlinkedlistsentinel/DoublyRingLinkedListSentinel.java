package io.github.gamelmw.video.linkedlist.Doublyringlinkedlistsentinel;

import java.util.Iterator;

public class DoublyRingLinkedListSentinel implements Iterable<Integer>{
    private static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node sentinel = new Node(null, -1, null);

    public DoublyRingLinkedListSentinel() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    //向链表头添加元素
    //value: 添加的元素
    public void addFirst(int value) {
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    //向链表末尾添加元素
    //value: 添加的元素
    public void addLast(int value) {
        Node a = sentinel.prev;
        Node b = sentinel;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    //删除头元素
    public void removeFirst() {
        Node removed = sentinel.next;
        if (removed == sentinel) {
            throw new IndexOutOfBoundsException("链表为空");
        }
        Node a = removed.prev;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    //删除末尾元素
    public void removeLast() {
        Node removed = sentinel.prev;
        if (removed == sentinel) {
            throw new IndexOutOfBoundsException("链表为空");
        }
        Node a = removed.prev;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    //根据值删除元素(删除第一个value值元素)
    //value: 删除的元素
    public void removeByValue(int value) {
        Node removed = findNode(value);
        if (removed == null) {
            throw new IndexOutOfBoundsException("链表中不存在该元素");
        }
        Node a = removed.prev;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    //查找指定值的元素
    //value: 查找的元素
    private Node findNode(int value) {
        for (Node p = sentinel.next; p != sentinel; p = p.next) {
            if (p.value == value) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p != sentinel;
            }
            @Override
            public Integer next() {
                int  value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
