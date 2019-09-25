package com.linkedlist.medium;



/**
 * LeetCode No142. Linked List Cycle II
 * 
 * 
 * 题解：
 *      给定一个链表 判断是否是环状链表，并且返回头节点到尾节点
 *      定义两个指针，一个每次进两个节点，一个每次进一个节点
 *      在某一节点他们会相遇，再在头节点处启用一个每次进一个节点的指针，并且同时移动这两个指针
 *      最终他们会在循环开始时相遇为止 
 * 
 */
public class ReverseLinkedListⅡ {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { 
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;				
            }
        }			
        return null;
    }
}
