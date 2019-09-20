package com.linkedlist.medium;


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
 *      给定一个排好序的链表，将其重复的值删除掉并保留一个
 *      解法一：
 *          采用循环的做法，遍历链表，因为给定的即是有序的，
 *          因此每次遍历比较当前节点和下一个节点的值是否相等即可，
 *          如果相等则将当前节点的下一个节点指向下下个节点，否则将当前节点指向下一个节点
 *      解法二：
 *          采用递归的做法，每次递归即是比较当前节点和下一个节点是否相等，临界条件是当前节点或者下一个节点为null
 */
public class RemoveDuplicatesFromSortedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        if(head == null) return node;
        while(head!=null){
            if(head.next != null){
                if(head.val == head.next.val) {
                    if (head.next.next != null) {
                        head.next = head.next.next;
                    } else {
                        head.next = null;
                    }
                } else {
                    head = head.next;
                }
            } else {
                head = null;
            }
        }
        return node;
    }


    public ListNode deleteDuplicatesRecursive(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicatesRecursive(head.next);
        return head.val == head.next.val ? head.next : head;
}
}
