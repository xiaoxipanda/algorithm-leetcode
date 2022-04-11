package com.code.linklist.no203;

import com.code.common.ListNode;

/**
 * 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 * @author markingWang
 * @date 2022/2/21 7:21 下午
 */
public class Solution {

    /**
     * 虚拟头指针
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode listNode = new ListNode(Integer.MIN_VALUE, head);
        ListNode tmp = listNode;
        while (tmp.next != null) {
            if (tmp.next.val == val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return listNode.next;
    }


    /**
     * 递归
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements01(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements01(head.next, val);
        return head.val == val ? head.next : head;
    }

}
