package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lihui
 */
public class RemoveDuplicates {
    /**
     * 1047. 删除字符串中的所有相邻重复项
     * @param s 字符串
     * @return 重复项删除操作会选择两个相邻且相同的字母，并删除它们。返回最终的字符串
     */
    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (c == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
