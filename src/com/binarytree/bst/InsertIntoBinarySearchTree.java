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
 *      根据给定值在指定的二叉搜索树中插入该值<p>
 *      因为二叉搜索树是区分左右大小的，因此在遍历该树的时候即可以找出给定值所在的上层父节点是哪个<p>
 *      在这里可以选择新建一个指向原有二叉树的引用，再通过遍历二叉树，找出给定值的父节点<p>
 *      如果比父节点大则新建在节点右侧，如果比比父节点小则新建在左侧,最终返回原先指向该树的引用即得所求
 */
public class InsertIntoBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return null;
        TreeNode node = root;
        while(node != null) {
            if(node.val > val) {
                if(node.left!=null) node = node.left;
                else{
                    node.left = new TreeNode(val);
                    break;
                }
            } else {
                if(node.right!=null) node = node.right;
                else {
                    node.right = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
    public TreeNode insertIntoBSTRecursive(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(root.val>val) {
            root.left = insertIntoBSTRecursive(root.left, val);
        }else{
            root.right = insertIntoBSTRecursive(root.right, val);
        }
        return root;
    }
}
