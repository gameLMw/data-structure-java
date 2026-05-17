package io.github.gamelmw.video.linkedlist.Doublyringlinkedlistsentinel;

import org.junit.jupiter.api.Test;

public class DoublyRingLinkedListSentinelTest {
    @Test
    public void test1() {
        DoublyRingLinkedListSentinel d = new DoublyRingLinkedListSentinel();
        d.addFirst(1);
        d.addFirst(2);

        for (int i : d){
            System.out.println(i);
        }
    }

    @Test
    public void test2() {
        DoublyRingLinkedListSentinel d = new DoublyRingLinkedListSentinel();

        d.removeFirst();
    }

    @Test
    public void test3() {
        DoublyRingLinkedListSentinel d = new DoublyRingLinkedListSentinel();

        d.removeLast();
    }

    @Test
    public void test4() {
        DoublyRingLinkedListSentinel d = new DoublyRingLinkedListSentinel();

        d.addLast(1);
        d.addLast(2);
        d.addLast(3);
        d.addLast(4);

        for (int i : d){
            System.out.println(i);
        }
        d.removeByValue(-1);
        System.out.println("------------------");
        for (int i : d){
            System.out.println(i);
        }
    }
}
