package com.code.old.no146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author markingWang
 * @date 2021/11/10 4:37 下午
 */
public class LRUCache02 {
    int capacity;
    LinkedHashMap<Integer, Integer> cache;

    public LRUCache02(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
