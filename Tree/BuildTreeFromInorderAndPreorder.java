import java.util.HashMap;
import java.util.Map;

// Question Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

/* Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
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

class BuildTreeFromInorderAndPreorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        
        for(int i=0; i<inorder.length; i++){
            inMap.put(inorder[i], i);
        }
        
        TreeNode root = buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
        
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap){
        if(preStart > preEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot-inStart;
        
        root.left = buildTree(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, inMap);
        root.right = buildTree(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, inMap);
        
        return root;
    }
}