package com.code.queuestack.no225;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack02 {

    Deque<Integer> queue1;
    public MyStack02() {
        queue1 = new ArrayDeque<>();
    }

    public void push(int x) {
        queue1.addLast(x);
    }

    public int pop() {
        int size = queue1.size();
        size--;
        while (size-- > 0){
            queue1.addLast(queue1.peekFirst());
            queue1.pollFirst();
        }

        return queue1.pollFirst();
    }

    public int top() {
        return queue1.peekLast();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
