package com.code.old.no876;

import com.code.common.ListNode;

/**
 * 链表的中间结点
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class Solution {
    /**
     * 数组或者list
     */
    public ListNode middleNode(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }

    /**
     * 单指针法
     */
    public ListNode middleNode01(ListNode head) {
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            ++n;
            curr = curr.next;
        }

        int k = 0;
        curr = head;
        while (k < n / 2) {
            k++;
            curr = curr.next;
        }
        return curr;
    }


    /**
     * 双指针法
     */
    public ListNode middleNode02(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
