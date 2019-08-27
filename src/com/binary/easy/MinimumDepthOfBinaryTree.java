package com.binary.easy;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * {@code LeetCode No111. Minimum Depth of Binary Tree}
 * <p>
 * 
 * 题解:<p>
 * 
 *      查找二叉树到叶子节点路径中的最小值<p>
 *      类似于在{@code No104. Maximum Depth of Binary Tree}是寻找子树的最大值，而在这里是找子树的最小值<p>
 *      或者类似于{@code No257. Binary Tree Paths}中可以得到到所有叶子节点的路径，然后最终得到最小的那条
 *      使用DFS方式或者BFS遍历即可
 */
public class MinimumDepthOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
       
    }

    public int minDepthDFSLoop(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> queue = new Stack<Integer>();
        if(root != null) {
            stack.push(root);
        }
        int temp = 0;
        queue.push(0);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            int a = queue.pop();
            a++;
            if(node.left == null && node.right == null) {
                temp = temp == 0 ? a : temp < a ? temp : a;
            }
            if(node.right!=null) {
                stack.push(node.right);
                queue.push(a);
            }
            if(node.left!=null) {
                stack.push(node.left);
                queue.push(a);
            }
        }
        
        return temp;
    }
}
