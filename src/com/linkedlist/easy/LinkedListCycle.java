package com.linkedlist.easy;



/**
 * LeetCode No141. Linked List Cycle
 * 
 * 
 * 题解：
 *      给定一个链表 判断是否是环状链表
*       使用两个指针，遍历链表，一个指针每次只走一步，另一个走两步，则如果是环状链表这两个指针会在某一瞬间相遇
 * 
 * 
 */
public class LinkedListCycle {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next!=null&&runner.next.next!=null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker == runner) {
                return true;
            }
        }
        return false;
    }
}
