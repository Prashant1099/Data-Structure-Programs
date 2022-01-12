// Question Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/

/* A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class BinaryTreeMaxPathSum {
    public int maxPathSum(TreeNode root) {
        int []sum = new int[1];
        sum[0] = Integer.MIN_VALUE;
        calculatePathSum(root, sum);
        
        return sum[0];
    }
    
    public int calculatePathSum(TreeNode root, int[] sum){
        if(root == null) return 0;
        
        int leftSum = Math.max(0, calculatePathSum(root.left, sum));
        int rightSum = Math.max(0, calculatePathSum(root.right, sum));
        
        sum[0] = Math.max(sum[0], leftSum+rightSum+root.val);
        
        return root.val + Math.max(leftSum, rightSum);
    }
}