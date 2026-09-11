package io.github.gamelmw.video.tree.binarysearchtree;

import org.junit.jupiter.api.Test;

public class BSTTree1Test {
    @Test
    public void test() {
        BSTTree1 KamenRider = new BSTTree1();
        KamenRider.put(1, "甲斗");
        KamenRider.put(7, "时王");
        KamenRider.put(3, "电王");
        KamenRider.put(5, "空我");
        KamenRider.put(2, "W");
        KamenRider.put(6, "帝骑");
        KamenRider.put(4, "龙骑");

        System.out.println(KamenRider.get(6));

        System.out.println(KamenRider.min());

        System.out.println(KamenRider.max());

        System.out.println(KamenRider.successor(3));

        System.out.println(KamenRider.predecessor(3));

        System.out.println("-------------");

        KamenRider.delete(3);
        KamenRider.inOrder();
    }
}
