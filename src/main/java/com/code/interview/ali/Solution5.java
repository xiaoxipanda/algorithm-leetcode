package com.code.interview.ali;


import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * www.abc.com/item?id=1 123
 * www.abc.com/search?key=apple 234
 * www.eee.com/item?id=2 123
 */
public class Solution5 {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        List<String> dataList = getDataFromFile("test.log");

        UvStatistics firstUvStatistics = new UvStatistics();
        UvStatistics twoUvStatistics = new UvStatistics();
        PvStatistics firstPvStatistics = new PvStatistics();
        PvStatistics twoPvStatistics = new PvStatistics();
        dataList.parallelStream().map(dataLine -> dataLine.split(" "))
                .filter(dataArray -> dataArray.length >= 2)
                .forEach(dataArray -> {
                    String hosts = dataArray[0];
                    String userID = dataArray[1];
                    // 统计uv
                    firstUvStatistics.statistics(hosts, userID, true);
                    twoUvStatistics.statistics(hosts, userID, false);
                    // 统计pv
                    firstPvStatistics.statistics(hosts, userID, true);
                    twoPvStatistics.statistics(hosts, userID, false);
                });
        for (Object o : firstUvStatistics.fixSizedPriorityQueue.getSortedList()) {
            ElementData e = (ElementData) o;
            System.out.println("一级域名下uv的host：" + e.host + "，" + "数量：" + e.nums);
        }
        for (Object o : twoUvStatistics.fixSizedPriorityQueue.getSortedList()) {
            ElementData e = (ElementData) o;
            System.out.println("二级域名下uv的host：" + e.host + "，" + "数量：" + e.nums);
        }
        for (Object o : firstPvStatistics.fixSizedPriorityQueue.getSortedList()) {
            ElementData e = (ElementData) o;
            System.out.println("一级域名下pv的host：" + e.host + "，" + "数量：" + e.nums);
        }
        for (Object o : twoPvStatistics.fixSizedPriorityQueue.getSortedList()) {
            ElementData e = (ElementData) o;
            System.out.println("二级域名下pv的host：" + e.host + "，" + "数量：" + e.nums);
        }
    }

    public interface Strategy {
        public void statistics(String hosts, String userID, boolean firstDomain);
    }

    public static class UvStatistics implements Strategy {
        public static final FixSizedPriorityQueue fixSizedPriorityQueue = new FixSizedPriorityQueue(10);
        private static final BloomFilter<String> bf = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()),
                1000000, 0.1);

        @Override
        public void statistics(String hosts, String userID, boolean firstDomain) {
            lock.lock();
            String host = hosts;
            if (firstDomain) {
                String[] hostsArray = hosts.split("/", 1);
                host = hostsArray[0];
            }
            if (bf.mightContain(host + "-" + userID)) {
                lock.unlock();
                return;
            }
            fixSizedPriorityQueue.add(new ElementData(host));
            bf.put(host + "-" + userID);
            lock.unlock();
        }
    }

    public static class PvStatistics implements Strategy {
        public static final FixSizedPriorityQueue fixSizedPriorityQueue = new FixSizedPriorityQueue(10);

        @Override
        public void statistics(String hosts, String userID, boolean firstDomain) {
            lock.lock();
            String host = hosts;
            if (firstDomain) {
                String[] hostsArray = hosts.split("/", 1);
                host = hostsArray[0];
            }
            fixSizedPriorityQueue.add(new ElementData(host));
            lock.unlock();
        }
    }

    public static List<String> getDataFromFile(String path) {

        List<String> res = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("test.log"));
            String str;
            while ((str = in.readLine()) != null) {
                res.add(str);
            }
        } catch (IOException e) {
            System.out.println("get data from file error" + e);
            throw new RuntimeException(e);
        }
        return res;
    }


    public static class ElementData implements Comparable {

        private String host;
        private Integer nums;

        public ElementData(String host) {
            this.host = host;
            this.nums += 1;
        }

        @Override
        public int compareTo(Object o) {
            ElementData e = (ElementData) (o);
            return e.nums - this.nums;
        }
    }


    public static class FixSizedPriorityQueue<E extends Comparable> {
        private PriorityBlockingQueue<E> queue;
        /**
         * 堆的最大容量
         */
        private int maxSize;

        public FixSizedPriorityQueue(int maxSize) {
            if (maxSize <= 0)
                throw new IllegalArgumentException();
            this.maxSize = maxSize;
            this.queue = new PriorityBlockingQueue<>(maxSize, new Comparator<E>() {
                public int compare(E o1, E o2) {
                    return (o1.compareTo(o2));
                }
            });
        }

        public void add(E e) {
            if (queue.size() < maxSize) { // 未达到最大容量，直接添加
                queue.add(e);
                lock.unlock();
                return;
            }
            // 队列已满
            E peek = queue.peek();
            if (peek != null && peek.compareTo(e) < 0) { // 将新元素与当前堆顶元素比较，保留较小的元素
                queue.poll();
                queue.add(e);
            }
        }

        public List<E> getSortedList() {
            List<E> list = new ArrayList<>(queue);
            Collections.reverse(list);
            return list;
        }
    }
}
