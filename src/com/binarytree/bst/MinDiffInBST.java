package leetcode.src.com.binarytree.bst;

/**
 * 783. Minimum Distance Between BST Nodes
 */
public class MinDiffInBST {


    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int pre = -1;
    int ans = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode node) {
      if(node == null) {
          return;
      }
      dfs(node.left);
      if(pre == -1) {
          pre = node.val;
      } else {
          ans = Math.min(ans, node.val - pre);
          pre = node.val;
      }
      dfs(node.right);
    }
}
