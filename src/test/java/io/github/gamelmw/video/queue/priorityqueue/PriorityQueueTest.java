package io.github.gamelmw.video.queue.priorityqueue;

import org.junit.jupiter.api.Test;

public class PriorityQueueTest {
    @Test
    public void test() {
        PriorityQueue1<Entry> q = new PriorityQueue1<>(5);
        q.offer(new Entry(1,2));
        q.offer(new Entry(2,1));
        q.offer(new Entry(3,9));
        q.offer(new Entry(4,4));
        q.offer(new Entry(5,7));
        q.offer(new Entry(6,2));

        for (Entry e : q) {
            System.out.println(e);
        }

        System.out.println("-------");

        q.poll();

        for (Entry e : q) {
            System.out.println(e);
        }
    }

    @Test
    public void test2() {
        PriorityQueue2<Entry> q = new PriorityQueue2<>(5);
        q.offer(new Entry(1,2));
        q.offer(new Entry(2,1));
        q.offer(new Entry(3,9));
        q.offer(new Entry(4,4));
        q.offer(new Entry(5,7));
        q.offer(new Entry(6,2));

        for (Entry e : q) {
            System.out.println(e);
        }

        System.out.println("-------");

        q.poll();

        for (Entry e : q) {
            System.out.println(e);
        }
    }
}
