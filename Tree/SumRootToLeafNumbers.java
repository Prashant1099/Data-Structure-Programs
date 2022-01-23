// Question Link: https://leetcode.com/problems/sum-root-to-leaf-numbers/

/* You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
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

class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }
    
    public int sumRootToLeaf(TreeNode node, int sum){
        if(node == null) return 0;
        
        sum = sum*10 + node.val;
        
        if(node.left == null && node.right == null) return sum;
        
        return sumRootToLeaf(node.left, sum) + sumRootToLeaf(node.right, sum);
    }
}