// Question Link: https://leetcode.com/problems/diameter-of-binary-tree/

/* Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them. 
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

class FindDiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        
        dfs(root, diameter);
        
        return diameter[0];
    }
    
    public int dfs(TreeNode root, int[] diameter){
        if(root == null) return 0;
        
        int leftHeight = dfs(root.left, diameter);
        int rightHeight = dfs(root.right, diameter);
        
        diameter[0] = Math.max(diameter[0], leftHeight+rightHeight);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}