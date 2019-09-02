package com.binarytree.easy;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * {@code LeetCode No257. Binary Tree Paths}
 * <p>
 * 
 * 题解:<p>
 * 
 *      查找二叉树的所有到叶子节点的路径<p>
 *      二叉树中叶子节点的定义为没有子树(左右节点)的节点<p> 
 *      这里主要还是考察二叉树的遍历，通过递归的方式选择前序遍历即可得出答案<p>
 *      同时DFS和BFS的方式同样可得<p>
 *      需要注意的是DFS的方式为使用栈存储节点，利用栈的先进后出的特性，优先存储右节点，从而达到最后遍历右节点的结果<p>
 *      而BFS的方式为使用队列存储节点，利用队列先进先出的特性，优先存储左节点，从而一致左右左右的遍历下去
 */
public class BinaryTreePaths {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return list;
        String s =  null;
        binaryTreePaths(root, s);
        return list;
    }
    public void binaryTreePaths(TreeNode root,String s) {
        if (root == null) {
            list.add(s);
        } else {
            s = s!=null ? s+ "->" + root.val : String.valueOf(root.val);
            if (root.left == null && root.right == null) {
                list.add(s);
            }
            if (root.left == null) {
                binaryTreePaths(root.right, s);
            }
            if (root.right == null) {
                binaryTreePaths(root.left, s);
            }
        }
    }

    public List<String> binaryTreePathsDFSLoop(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        Stack<String> sStack = new Stack<>();
        stack.push(root);
        sStack.push("");
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            String s = sStack.pop();
            if (node.left == null && node.right == null) {
                list.add(s + node.val);
            }
            if(node.right != null) {
                stack.push(node.right);
                sStack.push(s+ node.val + "->");
            }
            if(node.left != null) {
                stack.push(node.left);
                sStack.push(s+ node.val + "->");
            }
        }
        return list;
    }

    public List<String> binaryTreePathsBFSLoop(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<String> sQueue = new LinkedList<>();
        queue.offer(root);
        sQueue.offer("");
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String s = sQueue.poll();
            if(node.right == null && node.left == null) {
                list.add(s+node.val);
            }
            if(node.left != null) {
                queue.offer(node.left);
                sQueue.offer(s+node.val+"->");
            }
            if(node.right != null) {
                queue.offer(node.right);
                sQueue.offer(s+node.val+"->");
            }
        }
        return list;

    }
}
