package io.github.gamelmw.video.stack.linkedliststack;

import org.junit.jupiter.api.Test;

public class LinkedListStackTest {
    @Test
    public void test() {
        LinkedListStack<Integer> s = new LinkedListStack<>(5);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);

        for (Integer i : s) {
            System.out.println(i);
        }

        System.out.println("-------");

        s.pop();
        s.pop();

        for (Integer i : s) {
            System.out.println(i);
        }
    }
}
