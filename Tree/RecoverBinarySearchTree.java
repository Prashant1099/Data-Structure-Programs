// Question Link: https://leetcode.com/problems/recover-binary-search-tree/

/* You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
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

class RecoverBinarySearchTree {
    private TreeNode first;
    private TreeNode middle;
    private TreeNode prev;
    private TreeNode last;
    
    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        
        inorderTraversal(root);
        
        if(first != null && last != null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else if(first != null && middle != null){
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
    
    public void inorderTraversal(TreeNode node){
        if(node == null) return;
        inorderTraversal(node.left);
        
        if(node.val < prev.val){
            if(first == null){
                first = prev;
                middle = node;
            }
            else{
                last = node;
            }
        }
        
        prev = node;
        inorderTraversal(node.right);
    }
}