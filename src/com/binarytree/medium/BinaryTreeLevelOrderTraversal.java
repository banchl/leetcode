package com.binarytree.medium;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode No102. Binary Tree Level Order Traversal
 * 
 * 题解：
 *      给出一个二叉树，输出每一层的所有节点的值，使用列表存储
 *      采用 BFS 广度优先遍历的方式，计算每一层的节点个数，循环遍历该层的所有节点，输出到一个列表中
 *      这样每一层即可求得一个列表，最终汇总得解      
 *
 */
public class BinaryTreeRightSide {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root == null) return list;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> rList = new ArrayList();
            for(int i = 0;i<count;i++) {
                TreeNode node = queue.poll();
                rList.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            list.add(rList);
        }
        return list;
    }

}
