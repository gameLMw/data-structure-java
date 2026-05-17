package io.github.gamelmw.video.stack.arraystack;

import org.junit.jupiter.api.Test;

public class ArrayStackTest {
    @Test
    public void test() {
        ArrayStack<Integer> s = new ArrayStack<>(3);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        for (Integer i : s){
            System.out.println(i);
        }

        System.out.println("------");

        s.pop();
        for (Integer i : s){
            System.out.println(i);
        }
    }
}
