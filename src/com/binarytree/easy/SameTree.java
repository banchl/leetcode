package com.binarytree.easy;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * {@code LeetCode No100. Same Tree}
 * <p>
 * 
 * 题解:<p>
 * 
 *      判断两个二叉树是否是相等的二叉树<p>
 *      方法一：采取递归的方式，每次遍历即比较当前节点一的值是否等于节点二的值，
 *      接着比较当前节点一左子树节点和右子树节点与节点二的左子树节点和右子树节点是否相等
 *      临界条件为节点一二其中一个子树节点为null
 *      方法二：采用两个队列存储两个二叉树遍历的所有节点，每次比较左右节点是否相等或出现null值的临界条件
 */
public class SameTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean check(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return true;
      }
    
      public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (!check(p, q)) return false;
    
        // init deques
        ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
        deqP.addLast(p);
        deqQ.addLast(q);
    
        while (!deqP.isEmpty()) {
          p = deqP.removeFirst();
          q = deqQ.removeFirst();
    
          if (!check(p, q)) return false;
          if (p != null) {
            // in Java nulls are not allowed in Deque
            if (!check(p.left, q.left)) return false;
            if (p.left != null) {
              deqP.addLast(p.left);
              deqQ.addLast(q.left);
            }
            if (!check(p.right, q.right)) return false;
            if (p.right != null) {
              deqP.addLast(p.right);
              deqQ.addLast(q.right);
            }
          }
        }
        return true;
      }

    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        return (p.val == q.val)&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
