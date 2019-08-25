package com.easy.recursive;


/**
 *  LeetCode No21. Merge Two Sorted Lists
 *
 *  Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 *      Input: 1->2->4, 1->3->4
 *      Output: 1->1->2->3->4->4
 *
 * 题解：
 *      主要是采用递归思想，比较两个对象的值的大小，因为两个列表本身就是排好序的，因此，
 *      如果第一个节点当前值比第二个节点大,那么就拿第二个节点当作第一个节点的先节点，并继续比较第一个节点和第二个节点的下一个节点的大小情况
 *      如果第一个节点当前值比第二个节点小，则将第一个节点当作第二个节点的先节点，并继续比较第一个节点的下一个节点和第二个节点的大小
 *      循环下去，直到节点一或者节点二值为空递归结束
 */
public class MergeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }
        if (l1.val >= l2.val) {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        }
    }


    /**
     * 非递归解法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(0);
        ListNode prev = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 != null) {
            prev.next = l1;
        }
        if (l2 != null) {
            prev.next = l2;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        l.next = l1;
        l1.next = l2;

        ListNode n = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        n.next = n1;
        n1.next = n2;

        ListNode result = mergeTwoLists1(l, n);
        System.out.println(result);

    }

}
