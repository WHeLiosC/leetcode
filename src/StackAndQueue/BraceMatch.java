package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lihui
 */
public class BraceMatch {
    /**
     * 20. 有效的括号
     *
     * @param s 字符串
     * @return 判断字符串中的括号是否匹配
     */
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (char c : arr) {
            if (stack.isEmpty() && (c == ')' || c == ']' || c == '}')) {
                return false;
            }
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            char top = stack.peek();
            if (c == ')' && top != '(') {
                return false;
            }
            if (c == ']' && top != '[') {
                return false;
            }
            if (c == '}' && top != '{') {
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }
}
