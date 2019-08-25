package com.binary.medium;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode No53. Maximum Subarray
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *  5     4       <---
 *  
 * 题解：
 *      给出一个二叉树，输出从右边查看该二叉树时得到的值
 *      采用BFS 广度优先遍历即可得出答案 每次遍历可得到当前层的节点个数
 *      然后使用队列先进先出的概念取得当前层最后一个节点的值即可
 *      这里给出两种方式遍历子树：
 *      一、从右节点到左节点存入，则每次取当前层队列中第一个节点的值
 *      二、从左节点到右节点存入，则每次取当前层队列中最优一个节点的值,这种是真正的BFS遍历方式       
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

    public List<Integer> rightSideViewByRight(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return list;
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for(int i = 0; i<size; i++) {
                TreeNode node = queue.poll();
                if(list.size()<count) {
                    list.add(node.val);
                }
                if(node.right!=null) {
                    queue.offer(node.right);
                }
                if(node.left!=null) {
                    queue.offer(node.left);
                }
            }
        }
        return list;
    }

    public List<Integer> rightSideViewByLeft(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return list;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i<size; i++) {
                TreeNode node = queue.poll();
                if(i == size -1) {
                    list.add(node.val);
                }
                if(node.left!=null) {
                    queue.offer(node.left);
                }
                if(node.right!=null) {
                    queue.offer(node.right);
                }
            }
        }
        return list;
    }
}
