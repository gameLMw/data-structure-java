package io.github.gamelmw.video.linkedlist.singlylinkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SinglyLinkedListTest {
    @Test
    public void test1() {
        SinglyLinkedList s = new SinglyLinkedList();
        s.addFirst(1);
        s.addFirst(2);
        s.addFirst(3);
        s.addFirst(4);

        s.loop1(value -> System.out.println(value));

        System.out.println("---------------");

        s.loop2(value -> System.out.println(value));

        System.out.println("---------------");

        for (Integer value : s) {
            System.out.println(value);
        }
    }

    @Test
    public void test2() {
        SinglyLinkedList s = new SinglyLinkedList();
        s.addLast(1);
        s.addLast(2);
        s.addLast(3);
        s.addLast(4);

        Assertions.assertIterableEquals(List.of(1, 2, 3, 4), s);

        int v = s.get(-1);
        System.out.println(v);

        s.insert(0, 5);
        System.out.println("---------------");
        for (Integer value : s) {
            System.out.println(value);
        }

        System.out.println("---------------");
        for (Integer value : s) {
            System.out.println(value);
        }
    }

    @Test
    public void test3() {
        SinglyLinkedList s = new SinglyLinkedList();
        s.addLast(1);
        s.addLast(2);
        s.addLast(3);
        s.addLast(4);

        s.loop3();
    }
}
