package io.github.gamelmw.video.queue.linkedlistqueue;

import org.junit.jupiter.api.Test;

public class LinkedListQueueTest {
    @Test
    public void test() {
        LinkedListQueue<Integer> q = new LinkedListQueue<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);

        for (Integer i : q) {
            System.out.println(i);
        }
    }

    @Test
    public void test2() {
        LinkedListQueue<Integer> q = new LinkedListQueue<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);

        System.out.println(q.peek());

        System.out.println("-------");

        for (Integer i : q) {
            System.out.println(i);
        }

        System.out.println("-------");

        q.poll();

        for (Integer i : q) {
            System.out.println(i);
        }
    }

    @Test
    public void test3() {
        LinkedListQueue<Integer> q = new LinkedListQueue<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        q.offer(6);

        q.poll();

        for (Integer i : q) {
            System.out.println(i);
        }

        System.out.println("-------");

        System.out.println(q.peek());

        q.offer(7);

        System.out.println("-------");

        for (Integer i : q) {
            System.out.println(i);
        }
    }

    @Test
    public void test4() {
        LinkedListQueue<Integer> q = new LinkedListQueue<>(5);
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        q.offer(6);

        for (Integer i : q){
            System.out.println(i);
        }

        System.out.println("-------");

        q.poll();
        for (Integer i : q){
            System.out.println(i);
        }
    }
}
