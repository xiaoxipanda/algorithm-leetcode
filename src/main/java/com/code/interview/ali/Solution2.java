package com.code.interview.ali;

/**
 * 问题2：给出两个 非空 的链表用来表示两个非负的整数。它们各自的位数是按照 逆序 的方式存储的， //并且它们的每个节点只能存储 一位 数字。 将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 这两个非负整数都不会以 0 开头，您可以不考虑数字0开头的特殊情况。
 * 例如： 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author markingWang
 * @date 2021/11/10 7:33 下午
 */
public class Solution2 {
    /**
     * 获取链表相加之和
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 结果链接
     */
    public ListNode getTwoNumberNodeSum(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        // 前一次的进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;

            // 计算节点之和并加上进位
            int sum = n1 + n2 + carry;

            if (null == head) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            // 计算进位
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head;
    }

    private static class ListNode {

        public int val;

        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

