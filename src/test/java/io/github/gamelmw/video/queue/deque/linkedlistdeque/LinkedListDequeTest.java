package io.github.gamelmw.video.queue.deque.linkedlistdeque;

import org.junit.jupiter.api.Test;

public class LinkedListDequeTest {
    @Test
    public void test() {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(3);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerFirst(4);

        for (Integer i : deque) {
            System.out.println(i);
        }
    }

    @Test
    public void test2() {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(3);
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.offerLast(4);

        for (Integer i : deque) {
            System.out.println(i);
        }
    }

    @Test
    public void test3() {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(3);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerFirst(4);

        System.out.println(deque.pollFirst());
    }

    @Test
    public void test4() {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(3);
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.offerLast(4);

        System.out.println(deque.pollLast());

        System.out.println("------");

        for (Integer i : deque) {
            System.out.println(i);
        }
    }
}
