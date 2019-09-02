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
 *      求二叉树每层数值的平均值<p>
 *      这里就可以直接使用BFS遍历的方式，因为每次遍历都会扫描完一整层的节点，因此只需要记录该遍历的层次即可
 *      有一个坑就是在整数除的时候会默认保留整数，所以需要在计算和的时候就转成double计算，然后最后除的时候会保留初始化double时的小数位
 *
 */
public class AverageOfLevelsInBinaryTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> list = new ArrayList<>();
        if(root==null) return list;
        queue.offer(root);
        while(!queue.isEmpty()) {
            Integer count = queue.size();
            Double sum = 0.0;
            for(int i=0;i<count;i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            list.add(sum / count);
        } 
        return list;
    }
}
