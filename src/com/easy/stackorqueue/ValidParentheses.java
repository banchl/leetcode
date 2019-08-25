package com.easy.stackorqueue;


/**
 * LeetCode No.20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 *      1.Open brackets must be closed by the same type of brackets.
 *      2.Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 *
 *
 * 题解：
 *    利用栈的先入后出属性，因为操作符需要两两配对，因此在遇到左操作符时选择将对应的右操作符压入栈中，
 *    接着遍历到右操作符时就可以将栈中元素 pop 出，比较第一个 pop 出的元素是否和前一个 push 进栈中的
 *    有操作符匹配，如果不匹配则直接返回 false 否则就等到遍历完成后看栈中是否还有元素。
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else  if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' : deque.push(')'); break;
                case '[' : deque.push(']'); break;
                case '{' : deque.push('}'); break;
                default:
                    if (deque.isEmpty() || deque.pop() != c) {
                        return false;
                    } break;
            }
        }
        return deque.isEmpty();
    }


    public static boolean isValid3(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        char[] array = new char[s.length()];
        int head = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    array[head++] = c;
                    break;
                case ')':
                    if (head == 0 || array[--head] != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (head == 0 || array[--head] != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (head == 0 || array[--head] != '{') {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return (head == 0);
    }

    public static void main(String[] args) {
        String s = "{([])}";
        System.out.println(isValid1(s));
        System.out.println(isValid2(s));
        System.out.println(isValid3(s));

    }


}

