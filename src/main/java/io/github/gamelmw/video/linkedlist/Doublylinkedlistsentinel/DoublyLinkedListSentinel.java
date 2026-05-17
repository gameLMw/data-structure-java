package io.github.gamelmw.video.linkedlist.Doublylinkedlistsentinel;

import java.util.Iterator;

public class DoublyLinkedListSentinel implements Iterable<Integer> {
    static class Node {
        Node prev;//前一个节点指针
        int value;//值
        Node next;//下一个节点指针

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;//头哨兵
    private Node tail;//尾哨兵

    public DoublyLinkedListSentinel() {
        head = new Node(null, 666, null);
        tail = new Node(null, 888, null);
        head.next = tail;
        tail.prev = head;
    }

    //查找指定位置的元素
    //index: 索引
    private Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != tail; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    //向链表头添加元素
    //value: 添加的元素
    public void addFirst(int value) {
        insert(0, value);
    }

    //删除头元素
    public void removeFist() {
        remove(0);
    }

    //向链表末尾添加元素
    //value: 添加的元素
    public void addLast(int value) {
        Node last = tail.prev;
        Node added = new Node(last, value, tail);
        last.next = added;
        tail.prev = added;
    }

    //删除末尾元素
    public void removeLast() {
        Node removed = tail.prev;
        if (removed == head) {
            throw illegalIndex(0);
        }
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
    }

    //插入元素
    //index: 索引
    //value: 添加的元素
    public void insert(int index, int value) {
        Node prev = findNode(index - 1);//获取上一个节点
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node next = prev.next;
        Node inserted = new Node(prev, value, next);
        prev.next = inserted;
        next.prev = inserted;
    }

    //删除指定位置的元素
    //index: 索引
    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node removed = prev.next;
        if (removed == null) {
            throw illegalIndex(index);
        }
        Node next = removed.next;

        prev.next = next;
        next.prev = prev;
    }

    private IndexOutOfBoundsException illegalIndex(int index) {
        return new IndexOutOfBoundsException(
                String.format("index [%d] 不合法%n", index)
        );
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p != tail;
            }//是否有下一个元素

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }//返回当前元素，并指向下一个元素
        };
    }
}
