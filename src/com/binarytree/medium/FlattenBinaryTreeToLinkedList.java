package com.binarytree.medium;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode No114. Flatten Binary Tree to Linked List
 * 
 *  
 * 题解：
 *      给定一个二叉树，将其转成链表
 *      采用 DFS 遍历，将所有左节点转移到右节点上，优先转移左子树，从而保证最终全部移到右子树上
 *      或者采用反转 DFS 的方式遍历，优先将右子树转移到左子树的右节点上，最后将左子树转换成右子树
 */
public class FlattenBinaryTreeToLinkedList {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public void flattenRecursive(TreeNode root) {
        if (root==null) return;
        if(root.left != null) flattenRecursive(root.left);
        if(root.right != null) flattenRecursive(root.right);
        TreeNode node = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right!=null) root = root.right;
        root.right = node;
    }


    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
