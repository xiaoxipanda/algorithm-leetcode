package com.code.hot100;

import com.code.common.ListNode;

/**
 * TODO 链表两数相加
 * https://leetcode.cn/problems/add-two-numbers/
 */
public class Hot002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumRecursion(l1, l2, 0);
    }

    public ListNode addTwoNumRecursion(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;

        int carryVal = carry;
        if (l1 != null) {
            carryVal += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            carryVal += l2.val;
            l2 = l2.next;
        }
        ListNode node = new ListNode(carryVal % 10);
        node.next = addTwoNumRecursion(l1, l2, carryVal / 10);
        return node;
    }

    public ListNode addTwoNumbers01(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null, tail = null;
        while (l1 != null || l2 != null) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sum = l1Val + l2Val + carry;
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
}
