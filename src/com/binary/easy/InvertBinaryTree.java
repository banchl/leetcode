package com.binary.easy;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * {@code LeetCode No226. Invert Binary Tree}
 * <p>
 * 
 * 题解:<p>
 * 
 *      交换二叉树中的左右子树<p>
 *      1、递归的方式交换，每一次递归就是将左节点置为右节点，右节点指向左节点，遇到节点为null即返回null可得
 *      2、使用DFS（深度优先遍历的方式，使用栈存储），同样每次交换左右节点的指向
 *      3、使用BFS（广度优先遍历的方式，使用队列存储）
 *
 */
public class InvertBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode invertTreeRecursive(TreeNode root) {
          if(root == null) return null;
          TreeNode left = root.left,right = root.right;
          root.left = invertTree(right);
          root.right = invertTree(left);
          return root;
    }

    public TreeNode invertTreeDFSLoop(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return root;
    }

    public List<String> invertTreeBFSLoop(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;

    }
}
