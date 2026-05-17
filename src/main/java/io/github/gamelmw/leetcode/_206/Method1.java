package io.github.gamelmw.leetcode._206;

import io.github.gamelmw.leetcode.ListNode;

/*
* 头插法（新建一个链表，赋值）
* */

class Method1 {
    public ListNode reverseList(ListNode head) {
        ListNode n1 = null;
        ListNode n2 = head;
        while (n2 != null) {
            n1 = new ListNode(n2.val, n1) ;
            n2 = n2.next;
        }
        return n1;
    }
}