package com.binarytree.medium;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode No94. Binary Tree Inorder Traversal
 * 
 * 题解：
 *      给出一个二叉树，输出该二叉树得中序遍历结果
 *      最简单得当然就是递归的方式求解，依次求得左节点->根节点->右节点
 *      还有一种循环遍历的方式，使用栈存储节点，优先将树的所有左节点存储到栈中
 *      直至没有左节点为止，这个时候最终的这个节点可看作根节点，再指向这个节点的右节点，如果右节点不为空
 *      则继续遍历右节点的所有左节点，循环遍历所有节点即可得所求
 *
 */
public class BinaryTreeInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    List<Integer> list = new ArrayList();
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        if(root == null) return list;
        inorderTraversalRecursive(root.left);
        list.add(root.val);
        inorderTraversalRecursive(root.right);
        return list;
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root == null) return res;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) { 
            while (cur != null) {// Travel to each node's left child, till reach the left leaf
                stack.push(cur);
                cur = cur.left;				
            }		 
            cur = stack.pop(); // Backtrack to higher level node A
            res.add(cur.val);  // Add the node to the result list
            cur = cur.right;   // Switch to A'right branch
        }
        return res;
    }
}
