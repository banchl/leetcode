package com.linkedlist.medium;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * LeetCode No430. Flatten a Multilevel Doubly Linked List
 * 
 * 1-2-3-4-5-6
 *   |
 *   7-8-9-10        ----->        1-2-7-8-11-12--9-10-3-4-5-6
 *     |
 *     11-12
 * 
 * 题解：
 *      给定一个双向链表，包含子节点，转换成一条链表
 *      可以将链表90度顺时针旋转，可以看到类似一个二叉树，而所求即是使用二叉树的先序遍历方式
 * 
 *
 */
public class BinaryTreeInorderTraversal {

    public class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    
        public Node() {}
    
        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        Node node = null;
        if (head == null) {
            return node;
        }
        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new ArrayDeque<>();
        stack.push(head);
        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            Node result = queue.poll();
            if(curr.next != null) {
                stack.push(curr.next);
            }
            if(curr.child != null) {
                stack.push(curr.child);
            }
            if(result == null) {
                result = new Node(curr.val, null,null,null);
                node = result;
                queue.offer(result);
            } else {
                result.next = curr;
                curr.prev = result;
                curr.child = null;
                queue.offer(curr);
            }

        }
        return node;
    }
}
