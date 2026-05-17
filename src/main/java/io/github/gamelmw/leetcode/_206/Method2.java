package io.github.gamelmw.leetcode._206;

import io.github.gamelmw.leetcode.ListNode;

/*
 * 方法2，没有新的节点，只改变指针指向
 * */

public class Method2 {
    public ListNode reverseList(ListNode head) {
        ListNode n1 = null;
        ListNode n2 = head;

        while (n2 != null){
            ListNode n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        return n1;
    }
}
