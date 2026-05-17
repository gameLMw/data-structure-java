package io.github.gamelmw.video.queue.arrayqueue;

import org.junit.jupiter.api.Test;

public class ArrayQueueTest {
    @Test
    public void test() {
        ArrayQueue1<Integer> q = new ArrayQueue1<>(5);
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
    public void test2() {
        ArrayQueue2<Integer> q = new ArrayQueue2<>(5);
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
    public void test3() {
        ArrayQueue3<Integer> q = new ArrayQueue3<>(5);
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
}
