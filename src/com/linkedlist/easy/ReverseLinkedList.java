package com.linkedlist.easy;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * LeetCode No83. Remove Duplicates from Sorted List
 * 
 * 
 * 题解：
 *      给定一个排好序的链表，反转这个链表
 *      解法一：
 *          采用循环的做法，遍历链表，每次遍历新建一个节点指向当前值为当前遍历节点，
 *          然后新建节点的 next 指向返回值节点，从而交换了原本链表中前后节点的位置
 *      解法二：
 *          采用递归的做法，每次递归即是交换原有链表前后两个节点的位置，临界条件即是当前节点或者当前节点的下一个节点为null
 */
public class ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode node = null;
        while(head != null){
            ListNode t = new ListNode(head.val);
            t.next = node;
            node = t;
            head = head.next;
        }
        return node;
    }


    public ListNode reverseListRecursive(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode nextNode=head.next;
        ListNode newHead=reverseListRecursive(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;
    }
}
