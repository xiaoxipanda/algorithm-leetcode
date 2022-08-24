package com.code.hot100;

import com.code.common.DLinkedNode;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 缓存
 * https://leetcode.cn/problems/lru-cache/
 */
public class Hot146 {


    public class LRUCache {
        private Map<Integer, DLinkedNode> cache = new HashMap<>();
        DLinkedNode head, tail;
        int size;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            // 设置头和尾的虚拟节点
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) return -1;
            // 移动当前节点到头部
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode currNode = cache.get(key);
            if (currNode == null) {
                DLinkedNode node = new DLinkedNode(key, value);
                // 添加节点到cache
                cache.put(key, node);
                // 添加当前节点到头部
                addToHead(node);
                ++size;
                if (size > capacity) {
                    // 删除双向链表尾部节点
                    DLinkedNode tail = removeTail();
                    // 删除cache中的节点
                    cache.remove(tail.key);
                    --size;
                }
            } else {
                currNode.value = value;
                // 移动当前节点到头部
                moveToHead(currNode);
            }
        }

        private DLinkedNode removeTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }

        private void moveToHead(DLinkedNode node) {
            // 删除当前节点
            removeNode(node);
            // 添加当前节点到头部
            addToHead(node);
        }

        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addToHead(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }
    }


    public class LRUCache02 {
        public class DLinkedListNode {
            int key;
            int val;
            DLinkedListNode prev;
            DLinkedListNode next;

            public DLinkedListNode() {
            }

            public DLinkedListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private Map<Integer, DLinkedListNode> cache = new HashMap<>();
        private DLinkedListNode head, tail;
        private int size;
        private int capacity;

        public LRUCache02(int capacity) {
            this.capacity = capacity;
            size = 0;
            head = new DLinkedListNode();
            tail = new DLinkedListNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedListNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            // 移动节点到头部
            moveToHead(node);
            return node.val;
        }


        public void put(int key, int value) {
            DLinkedListNode node = cache.get(key);
            if (node == null) {
                DLinkedListNode newNode = new DLinkedListNode(key, value);
                cache.put(key, newNode);
                // 添加节点到头部
                addToHead(newNode);
                size++;
                if (size > capacity) {
                    // 删除尾节点
                    DLinkedListNode tail = removeTail();
                    // 从cache中删除尾节点
                    cache.remove(tail.key);
                    size--;
                }
            } else {
                node.val = value;
                // 移动节点到头部
                moveToHead(node);
            }
        }

        private DLinkedListNode removeTail(){
            DLinkedListNode res = tail.prev;
            removeNode(res);
            return res;
        }

        private void removeNode(DLinkedListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addToHead(DLinkedListNode node) {
            node.prev = head;
            node.next = head.next;
            node.next.prev =node;
            head.next = node;
        }

        private void moveToHead(DLinkedListNode node) {
            // 删除当前节点
            removeNode(node);
            // 添加节点到头部
            addToHead(node);
        }
    }
}
