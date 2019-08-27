package com.binary.easy;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * {@code LeetCode No617. Merge Two Binary Trees}
 * <p>
 * 题解：<p>
 *      合并两个二叉树<p>
 *      二叉树的遍历的方式主要有前中后三种排序，分别为：<p>
 *      1.前序：根->左->右<p>
 *      2.中序：左->根->右<p>
 *      3.后序：左->右->根<p>
 *      同时在二叉树中前序遍历即为深度优先搜索，而另一种广度优先搜索则是采用根->左右->左右的方式<p>
 *      这里可以采用递归的方式遍历二叉树，每次遍历的时候合并子节点的值加入到新生成的二叉树中，左节点对应左节点，右节点对应右节点<p>
 *      同时查看题解的时候找到了使用DFS和BFS两种方式遍历的解法
 *
 */
public class MergeTwoBinaryTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode mergeTreesRecursive(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        TreeNode node = new TreeNode(0);
        node.val = t1.val + t2.val;

        node.left = mergeTreesRecursive(t1.left, t2.left);
        node.right = mergeTreesRecursive(t1.right, t2.right);
        return node;
    }

    // Method 2: Iterative DFS
    // Time: O(n)
    // Space: O(height)
    public TreeNode mergeTreesDFSLoop(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        // Use stack to help DFS
        Deque<TreeNode[]> stack = new LinkedList<>();
        stack.offerLast(new TreeNode[] {t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] cur = stack.pollLast();
            // no need to merge t2 into t1
            if (cur[1] == null) {
                continue;
            }
            // merge t1 and t2
            cur[0].val += cur[1].val;
            // if node in t1 == null, use node in t2 instead
            // else put both nodes in stack to merge
            if (cur[0].left == null) {
                cur[0].left = cur[1].left;
            } else {
                stack.offerLast(new TreeNode[] {cur[0].left, cur[1].left});
            }
            if (cur[0].right == null) {
                cur[0].right = cur[1].right;
            } else {
                stack.offerLast(new TreeNode[] {cur[0].right, cur[1].right});
            }
        }
        return t1;
    }

    // Method 3: Iterative BFS
    // Time: O(n)
    // Space: O(n)
    public TreeNode mergeTreesBFSLoop(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        // Use stack to help DFS
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[] {t1, t2});
        while (!queue.isEmpty()) {
            TreeNode[] cur = queue.poll();
            // no need to merge t2 into t1
            if (cur[1] == null) {
                continue;
            }
            // merge t1 and t2
            cur[0].val += cur[1].val;
            // if node in t1 == null, use node in t2 instead
            // else put both nodes in stack to merge
            if (cur[0].left == null) {
                cur[0].left = cur[1].left;
            } else {
                queue.offer(new TreeNode[] {cur[0].left, cur[1].left});
            }
            if (cur[0].right == null) {
                cur[0].right = cur[1].right;
            } else {
                queue.offer(new TreeNode[] {cur[0].right, cur[1].right});
            }
        }
        return t1;
    }
}
