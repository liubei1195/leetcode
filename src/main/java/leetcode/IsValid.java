package leetcode;

import java.util.Stack;

/**
 * 有效的括号
 */

public class IsValid {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }

        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
