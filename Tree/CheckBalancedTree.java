/* Question link: https://leetcode.com/problems/balanced-binary-tree/
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:
a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
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

class CheckBalancedTree {
    public boolean isBalanced(TreeNode root) {
        if(dfs(root) == -1) return false;
        
        return true;
    }
    
    public int dfs(TreeNode root){
        if(root == null) return 0;
        
        int leftHeight = dfs(root.left);
        if(leftHeight == -1) return -1;
        
        int rightHeight = dfs(root.right);
        if(rightHeight == -1) return -1;
        
        if(Math.abs(leftHeight - rightHeight) > 1) return -1;
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}