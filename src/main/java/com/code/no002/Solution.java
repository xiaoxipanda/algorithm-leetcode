package com.code.no002;

import com.code.common.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;

            int sum = n1 + n2 + carry;

            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = 0;
            if (l1 != null) {
                n1 = l1.val;
                l1 = l1.next;
            }

            int n2 = 0;
            if (l2 != null) {
                n2 = l2.val;
                l2 = l2.next;
            }

            int sum = n1 + n2 + carry;
            carry = sum / 10;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail = tail.next = new ListNode(sum % 10);
            }
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
