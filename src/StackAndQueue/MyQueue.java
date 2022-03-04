package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lihui
 * 232.用栈实现队列
 */
public class MyQueue {
    private Deque<Integer> stackIn, stackOut;

    public MyQueue() {
        stackIn = new LinkedList<>();
        stackOut = new LinkedList<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    public int peek() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
