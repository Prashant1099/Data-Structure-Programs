// Question Link: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

/* Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.

It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.

A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.

A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.
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

class ConstructBstFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        
        if(preorder.length == 1) return root;
        
        for(int i=1; i<preorder.length; i++){
            constructBST(root, preorder[i]);
        }
        
        return root;
    }
    
    public void constructBST(TreeNode node, int value){
        if(node == null) return;
        
        if(node.val < value){
            if(node.right == null) node.right = new TreeNode(value);
            else constructBST(node.right, value);
        }
        else{
            if(node.left == null) node.left = new TreeNode(value);
            else constructBST(node.left, value);
        }
    }
}