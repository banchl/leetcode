package com.binarytree.bst;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * {@code LeetCode No108. Convert Sorted Array to Binary Search Tree}
 * <p>
 * 
 * 题解:<p>
 * 
 *      将给出的升序数组转换成平衡二叉搜索树<p>
 *      平衡二叉树要求左右子树的高度基本相等，这里要求高度相差不过一
 *      解法一：
 *          循环遍历数组，由于数组是升序的，因此树的根节点会找到数组中间位置的值做为根节点
 *          从中值往两边找，小于当前值的为左值，大于当前值的为右值，同时会有队列存储左值下标和右值下标
 *          左子树的即是从数组中值左侧下标值组成，因此，构建左子树相当于在左侧下标值中重复找中值再分割
 *          同理右子树即是由数组中值右侧下标值组成，构建方式类似左子树
 *      解法二：
 *          使用递归求解，同样是构建左右子树，每次递归即求出给定值的左右节点，在第一次取好中值后，
 *          每次递归即构建一层左右子节点，临界条件是左节点下标大于右节点下标
 *          
 */
public class ConvertSortedArrayToBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if ( len == 0 ) { return null; }
        
        // 0 as a placeholder
        TreeNode head = new TreeNode(0); 
        
        Deque<TreeNode> nodeStack       = new LinkedList<>() {{ push(head);  }};
        Deque<Integer>  leftIndexStack  = new LinkedList<>()  {{ push(0);     }};
        Deque<Integer>  rightIndexStack = new LinkedList<>()  {{ push(len-1); }};
        
        while ( !nodeStack.isEmpty() ) {
            TreeNode currNode = nodeStack.pop();
            int left  = leftIndexStack.pop();
            int right = rightIndexStack.pop();
            int mid   = left + (right-left)/2; // avoid overflow
            currNode.val = nums[mid];
            if ( left <= mid-1 ) {
                currNode.left = new TreeNode(0);  
                nodeStack.push(currNode.left);
                leftIndexStack.push(left);
                rightIndexStack.push(mid-1);
            }
            if ( mid+1 <= right ) {
                currNode.right = new TreeNode(0);
                nodeStack.push(currNode.right);
                leftIndexStack.push(mid+1);
                rightIndexStack.push(right);
            }
        }
        return head;
    }

    public TreeNode sortedArrayToBSTRecursive(int[] nums) {
        if (num.length == 0) {
            return null;
        }
        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }
}
