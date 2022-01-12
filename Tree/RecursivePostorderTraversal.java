// Question Link: https://leetcode.com/problems/binary-tree-postorder-traversal

import java.util.ArrayList;
import java.util.List;

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

class RecursivePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        traversal(root, ans);
        
        return ans;
    }
    
    public void traversal(TreeNode root, List<Integer> ans){
        if(root == null) return;
        
        traversal(root.left, ans);
        traversal(root.right, ans);
        ans.add(root.val);
    }
}


