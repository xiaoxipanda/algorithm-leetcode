package com.code.no019;

import com.code.common.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 删除链表的倒数第 N 个结点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class Solution {

    /**
     * 计算链表长度
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        int length = getLength(head);
        ListNode curr = dummy;
        for (int i = 0; i < length - n + 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }

    public int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    /**
     * 栈
     */
    public ListNode removeNthFromEnd01(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode curr = dummy;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }

        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd02(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }

    /**
     * 双指针
     */
    public ListNode removeNthFromEnd03(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fist = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            fist = fist.next;
        }
        while (fist != null){
            fist = fist.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
