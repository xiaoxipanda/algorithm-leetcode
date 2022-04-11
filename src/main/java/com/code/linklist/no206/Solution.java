package com.code.linklist.no206;

import com.code.common.ListNode;

/**
 * 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author markingWang
 * @date 2022/2/22 7:59 下午
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public ListNode reverseList01(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList01(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList02(ListNode pre, ListNode curr) {
        if (curr == null) {
            return pre;
        }

        ListNode next = curr.next;
        curr.next = pre;
        return reverseList02(curr, next);
    }

}
