package com.code.no146;

import com.code.common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 缓存机制
 * https://leetcode-cn.com/problems/lru-cache/
 */
public class LRUCache03 {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache03(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        // 删除节点
        node.prev.next = node.next;
        node.next.prev = node.prev;

        // 添加到头
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        return node.value;
    }


    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            newNode.prev = head;
            newNode.next = head.next;
            head.next.prev = newNode;
            head.next = newNode;
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode res = tail.prev;
                removeNode(res);
                // 删除哈希表中对应的项
                cache.remove(res.key);
                --size;
            }
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;

            // 删除节点
            removeNode(node);

            // 添加到头部
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }
    }


    private void removeNode(LRUCache03.DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}
