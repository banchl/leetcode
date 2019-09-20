package com.linkedlist.medium;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * LeetCode No82. Remove Duplicates from Sorted List II
 * 
 * 
 * 题解：
 *      给定一个排好序的链表，将其重复的值删除掉并且不保留
 *      给定两个ListNode指向当前节点和前一个节点，
 *      只有当前节点和前一个节点不同并且当前节点和后一个节点不同时才是不会重复的值作以保留
 */
public class RemoveDuplicatesFromSortedListⅡ {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode pre=FakeHead;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){
                pre=pre.next;
            }
            else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return FakeHead.next;
    }


    public ListNode deleteDuplicatesRecursive(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicatesRecursive(head.next);
        return head.val == head.next.val ? head.next : head;
}
}
