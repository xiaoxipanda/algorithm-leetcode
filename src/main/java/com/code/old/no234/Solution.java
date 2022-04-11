package com.code.old.no234;

import com.code.common.ListNode;

/**
 * 单链表回文串判断
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (null == head || null == head.next) {
            return true;
        }

        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            ListNode slowNext = slow.next;
            slow.next = pre;
            pre = slow;
            slow = slowNext;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != pre.val) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }

        return true;
    }
}
