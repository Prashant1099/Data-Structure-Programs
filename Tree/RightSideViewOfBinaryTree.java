import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-right-side-view/

/* Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
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

class RightSideViewOfBinaryTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        treeTraversal(root, 0, ans);
        
        return ans;
    }
    
    public void treeTraversal(TreeNode node, int level, List<Integer> ans){
        if(node == null) return;
        
        if(level == ans.size()) ans.add(node.val);
        
        treeTraversal(node.right, level+1, ans);
        treeTraversal(node.left, level+1, ans);
    }
}