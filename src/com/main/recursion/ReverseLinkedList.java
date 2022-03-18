package com.main.recursion;

import com.main.linked_lists.ListNode;

public class ReverseLinkedList {
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tempNode = reverseList(head.next);
        head.next.next = tempNode;
        head.next = null;
        return tempNode;
    }
}
