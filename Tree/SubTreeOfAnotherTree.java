// https://leetcode.com/problems/subtree-of-another-tree/

/* Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
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

class SubTreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        
        if(checkIdentical(root, subRoot)) return true;
        
        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }
    
    public boolean checkIdentical(TreeNode root, TreeNode subRoot){
        if(root == null || subRoot == null) return (root == subRoot);
        
        if(root.val != subRoot.val) return false;
        
        return (checkIdentical(root.left, subRoot.left) && checkIdentical(root.right, subRoot.right));
    }
}