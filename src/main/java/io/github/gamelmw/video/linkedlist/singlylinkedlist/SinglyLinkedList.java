package io.github.gamelmw.video.linkedlist.singlylinkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/*
 * 单项链表
 * 特性：链表的每个元素都称为节点，每个节点包含数据域和指向下一个节点的指针。
 * */

public class SinglyLinkedList implements Iterable<Integer> {
    private final Node head = new Node(666, null);

    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    // 头插
    // value: 插入的值
    public void addFirst(int value) {
        insert(0, value);
    }

    // 循环1
    // while循环
    // 函数式接口（只有1个抽象方法的接口）
    public void loop1(Consumer<Integer> consumer) {
        Node p = head.next;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    // 循环2
    // 增强for循环
    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head.next; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    // 循环3
    // 迭代器
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public Integer next() {
                int v = p.value;
                p = p.next;
                return v;
            }
        };
    }

    // 循环4
    // 递归
    public void loop3() {
        recursion(head.next);
    }

    // 递归
    private void recursion(Node curr) {
        if (curr == null) {
            return;
        }
        System.out.println("before:" + curr.value);
        recursion(curr.next);
        System.out.println("after:" + curr.value);
    }

    // 尾插
    // value: 插入的值
    public void addLast(int value) {
        Node last = findLast();
        last.next = new Node(value, null);
    }

    // 查找最后一个节点
    private Node findLast() {
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    // 查找指定位置的节点
    // index: 索引
    private Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    // 获取指定位置的元素
    // index: 索引
    public int get(int index) {
        Node node = findNode(index);
        if (node == null) {
            throw illegalIndex(index);
        }
        return node.value;
    }

    // 索引越界异常
    private static IndexOutOfBoundsException illegalIndex(int index) {
        return new IndexOutOfBoundsException(
                String.format("index [%d] not valid", index)
        );
    }

    // 插入
    // index: 索引
    // value: 插入的值
    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        prev.next = new Node(value, prev.next);
    }

    // 删除头节点
    public void removeFirst() {
        remove(0);
    }

    // 删除
    // index: 索引
    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node removed = prev.next;
        if (removed == null) {
            throw illegalIndex(index);
        }
        prev.next = removed.next;
    }
}
