package io.github.gamelmw.video.linkedlist.Doublylinkedlistsentinel;

import org.junit.jupiter.api.Test;

public class DoublyLinkedListSentinelTest {
    @Test
    public void test1() {
        DoublyLinkedListSentinel d = new DoublyLinkedListSentinel();
        d.addLast(1);
        d.addLast(2);
        d.addLast(3);
        d.addLast(4);

        for (Integer value : d) {
            System.out.println(value);
        }

        System.out.println("---------------");

        d.remove(0);
        for (Integer value : d) {
            System.out.println(value);
        }
    }

    @Test
    public void test2() {
        DoublyLinkedListSentinel d = new DoublyLinkedListSentinel();

        d.removeLast();

        for (Integer value : d) {
            System.out.println(value);
        }
    }

    @Test
    public void test3() {
        DoublyLinkedListSentinel d2 = null;
        DoublyLinkedListSentinel d1 = new DoublyLinkedListSentinel();
        d1.addLast(1);
        d1.addLast(2);
        d1.addLast(3);
        d1.addLast(4);

        d2 = d1;
        for (Integer value : d2) {
            System.out.println(value);
        }
        System.out.println("---------------");
        d2.removeLast();
        for (Integer value : d1) {
            System.out.println(value);
        }
    }
}
