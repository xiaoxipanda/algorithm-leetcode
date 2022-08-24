package com.code.hot100;


import com.code.common.ListNode;

/**
 * 两两交换链表中的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 */
public class Hot024 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode two = first.next;
        ListNode three = two.next;
        two.next = first;
        first.next = swapPairs(three);
        return two;
    }
}
