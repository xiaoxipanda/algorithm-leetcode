package com.code.no141;

import com.code.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断是否为环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seenSet = new HashSet<>();
        while (head != null) {
            if (!seenSet.add(head)) {
                return true;
            }
            head = head.next;
        }

        return false;
    }

    public boolean hasCycle01(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        do {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        return true;
    }
}
