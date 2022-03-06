package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Lihui
 */
public class ReversePolishNotation {
    /**
     * 150. 逆波兰表达式求值
     *
     * @param tokens tokens[i] 是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数
     * @return 根据逆波兰表示法，返回表达式的值
     */
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {

            // 如果是运算符，则弹出两个操作数，并将结果压回栈里
            if ("+".equals(token)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(token)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 - num1);
            } else if ("*".equals(token)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(token)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 / num1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
