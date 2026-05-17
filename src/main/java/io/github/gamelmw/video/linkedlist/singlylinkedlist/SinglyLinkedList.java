package io.github.gamelmw.video.linkedlist.singlylinkedlist;

/*
 * 单项链表
 * */

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedList implements Iterable<Integer> {
    //增加哨兵节点
    private Node head = new Node(666, null);//头指针

    //节点类
    private static class Node {
        int value;//值
        Node next;//下一个节点指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    //向链表头添加元素
    //value: 添加的元素
    public void addFirst(int value) {
//        //1.链表为空
////        head = new Node(value, null);
//        //2.链表非空
//        head = new Node(value, head);
        insert(0, value);
    }

    //遍历链表方法1
    public void loop1(Consumer<Integer> consumer) {
        Node p = head.next;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    //遍历链表方法2
    //consumer: 遍历的消费者
    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head.next; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    //遍历链表方法3
    //迭代器
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {//是否有下一个元素
                return p != null;
            }

            @Override
            public Integer next() {//返回当前元素，并指向下一个元素
                int v = p.value;
                p = p.next;
                return v;
            }
        };
    }

    //遍历链表方法4
    //递归遍历
    public void loop3() {
        recursion(head.next);
    }

    private void recursion(Node curr) {
        if (curr == null) {
            return;
        }
        System.out.println("before:" + curr.value);
        recursion(curr.next);
        System.out.println("after:" + curr.value);
    }

    //查找末尾元素
    private Node findLast() {
//        if (head == null) {
//            return null;
//        }
        Node p;
        for (p = head; p.next != null; p = p.next) {

        }
        return p;
    }

    //添加末尾元素
    //value 添加的元素
    public void addLast(int value) {
        Node last = findLast();
//        if (last == null) {
//            addFirst(value);
//            return;
//        }
        last.next = new Node(value, null);
    }

    //查找指定位置的元素
    //index: 索引
    public Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;//未找到
    }

    //获取指定位置的元素
    //index: 索引
    public int get(int index) {
        Node node = findNode(index);
        if (node == null) {
            throw illegalIndex(index);
        }
        return node.value;
    }

    //创建非法索引异常
    private static IndexOutOfBoundsException illegalIndex(int index) {
        return new IndexOutOfBoundsException(
                String.format("index [%d] 不合法%n", index)
        );
    }

    //插入元素
    //index: 索引
    //value: 添加的元素
    public void insert(int index, int value) {
//        if (index == 0){
//            addFirst(value);
//            return;
//        }
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        prev.next = new Node(value, prev.next);
    }

    //删除头元素
    public void removeFist() {
//        if (head == null) {
//            throw illegalIndex(0);
//        }
//        head = head.next;
        remove(0);
    }

    //删除指定位置的元素
    //index: 索引
    public void remove(int index) {
//        if (index == 0) {
//            removeFist();
//            return;
//        }
        Node prev = findNode(index - 1);//获取前一个节点
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node removed = prev.next;//获取删除的节点
        if (removed == null) {
            throw illegalIndex(index);
        }
        prev.next = removed.next;
    }
}
