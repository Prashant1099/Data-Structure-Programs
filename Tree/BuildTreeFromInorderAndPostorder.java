import java.util.HashMap;
import java.util.Map;

// Question Link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

/* Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
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

class BuildTreeFromInorderAndPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        
        for(int i=0; i<inorder.length; i++){
            inMap.put(inorder[i], i);
        }
        
        TreeNode root = buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inMap);
        
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inMap){
        if(postStart > postEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot-inStart;
        
        root.left = buildTree(inorder, inStart, inRoot-1, postorder, postStart, postStart+numsLeft-1, inMap);
        root.right = buildTree(inorder, inRoot+1, inEnd, postorder, postStart+numsLeft, postEnd-1, inMap);
        
        return root;
    }
}