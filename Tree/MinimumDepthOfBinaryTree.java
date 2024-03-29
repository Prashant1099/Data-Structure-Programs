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
class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        int ans = calculateMinimumDepth(root);
        
        return ans;
    }
    
    public int calculateMinimumDepth(TreeNode root){
        if(root == null) return Integer.MAX_VALUE;
        
        if(root.left == null && root.right == null) return 1;
        
        int leftDepth = calculateMinimumDepth(root.left);
        int rightDepth = calculateMinimumDepth(root.right);
        
        return (1 + Math.min(leftDepth, rightDepth));
    }
}