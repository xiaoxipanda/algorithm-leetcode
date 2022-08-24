package com.code.linklist.no077;

import com.code.common.ListNode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 链表排序
 * https://leetcode.cn/problems/7WHec2/
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        while (head != null) {
            heap.add(head);
            head = head.next;
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (heap.size() > 0) {
            cur.next = heap.poll();
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }

    public ListNode sortList1(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }
        listNodes.sort((o1, o2) -> o1.val - o2.val);

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (ListNode node : listNodes) {
            cur.next = node;
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(5, null));
    }

    public static double sqrt(int t, Double precise) {

        if (t < 0) {
            throw new RuntimeException("Negative number cannot have a sqrt root.");
        }

        //先确定当前数所处的最小整数区间
        int i = 0;
        for (; i <= t; i++) {
            if (i * i == t) {
                return i;
            }
            if (i * i > t) {
                break;
            }
        }


        AtomicInteger s = new AtomicInteger();
        s.getAndIncrement();
        //再通过二分法来进行判断检测
        double low = i - 1, high = i, prec = precise != null ? precise : 1e-7;
        double middle, squre;
        while (high - low > prec) {
            middle = (low + high) / 2;
            squre = middle * middle;

            if (squre > t) {
                high = middle;
            } else {
                low = middle;
            }
        }
        return (low + high) / 2;
    }

}
