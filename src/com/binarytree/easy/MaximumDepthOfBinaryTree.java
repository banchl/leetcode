package com.binarytree.easy;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * {@code LeetCode No104. Maximum Depth of Binary Tree}
 * <p>
 * 
 * 题解:<p>
 * 
 *      查找二叉树到叶子节点路径中的最大值<p>
 *      在{@code No257. Binary Tree Paths}中可以得到到所有叶子节点的路径<p>
 *      类似的这一题也可以通过遍历所有子树的方式找到所有到叶子节点的路径长度，然后取最长的一个
 *      还可以通过递归的方式比较左右子树的长度，每次递归加一，最终得到最大的子树长度
 */
public class MaximumDepthOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public int c = 0;
    public int maxDepth(TreeNode root) {
        return maxDepth(root, c);
    }
    
    public int maxDepth(TreeNode root, int result) {
        if(root == null) return result > c ? c=result:c;
        result++;
        maxDepth(root.left, result);
        maxDepth(root.right, result);
        return c;
    }

    public int maxDepthRecursive(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1+Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right));
    }
}
