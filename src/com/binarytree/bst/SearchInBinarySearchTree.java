package com.binarytree.bst;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * {@code LeetCode No700. Search in a Binary Search Tree}
 * <p>
 * 
 * 题解:<p>
 * 
 *      根据给定值在指定的二叉搜索树中找出对应子树<p>
 *      二叉搜索树是一个节点左侧的所有值都小于节点右侧的所有值的二叉树<p>
 *      通过比较给定值和当前节点值的大小，决定下一次遍历时树的起始节点是当前节点的左节点(当前节点值大于给定值)还是右节点(当前节点值小于给定值)
 */
public class SearchInBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode searchBSTRecursive(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        TreeNode right = null;
        TreeNode left = null;
        if(root.val > val) {
            left = searchBSTRecursive(root.left, val);
        }
        if(root.val < val) {
            right = searchBSTRecursive(root.right, val);
        }
        return left == null ? right == null ? null : right : left;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        while(root!=null&&root.val!=val) {
            root = root.val > val ? root.left : root.right;
        }
        return root;
    }
}
