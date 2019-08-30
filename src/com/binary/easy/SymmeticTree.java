package com.binary.easy;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * {@code LeetCode No101. Symmetric Tree}
 * <p>
 * 
 * 题解:<p>
 * 
 *      判断二叉树是否是对称二叉树<p>
 *      使用BFS遍历的方式，每次遍历将对应的左右节点分别存入相应的队列中，然后每一层遍历时取出对应的左右节点比较值是否相等<p>
 *      如果出现不相等或者遍历的时候节点左右子节点存储一个为空另一个不为空的情况则返回false<p>
 *      因为对称的条件即是左子树上的左节点对应右子树上的右节点<p>
 *      查看题解之后有一种递归的方式解决，每次递归即将左子树的左节点和右子树的右节点相比较，将左子树的右节点和右子树的左节点相比较<p>
 *      从而可以得出左子树的所有左节点是否等于右子树的右节点，右节点同理
 */
public class SymmeticTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> stack = new LinkedList<TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        stack.offer(root);
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i =0;i<size;i++) {
                TreeNode rightNode = stack.poll();
                TreeNode leftNode = queue.poll();
                if(leftNode.val != rightNode.val) {
                    return false;
                }
                if(leftNode.left == null && rightNode.right != null) {
                    return false;
                }
                if(leftNode.left != null && rightNode.right == null) {
                    return false;
                }
                if(leftNode.right == null && rightNode.left != null) {
                    return false;
                }
                if(leftNode.right != null && rightNode.left == null) {
                    return false;
                }
                if(leftNode.left != null) {
                    queue.offer(leftNode.left);
                }
                if(leftNode.right != null) {
                    queue.offer(leftNode.right);
                }
                if(rightNode.right != null){
                    stack.offer(rightNode.right);
                }
                if(rightNode.left != null) {
                    stack.offer(rightNode.left);
                }
            }
        }
        return true;
    }

    public boolean isSymmetricRecursive(TreeNode root) {
        return root==null || isSymmetricHelp(root.left, root.right);
    }
    
    private boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
}
