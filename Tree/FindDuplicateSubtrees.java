import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Question Link: https://leetcode.com/problems/find-duplicate-subtrees/

/* Given the root of a binary tree, return all duplicate subtrees.

For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with the same node values.
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

class FindDuplicateSubtrees {
    Map<String, Integer> hashMap = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traversal(root);
        
        return ans;              
    }
    
    public String traversal(TreeNode root){
        if(root == null) return "N";
        
        String left = traversal(root.left);
        String right = traversal(root.right);
        
        String cur = root.val + " " + left + " " + right;
        
        hashMap.put(cur, hashMap.getOrDefault(cur, 0)+ 1);
        
        if(hashMap.get(cur) == 2) ans.add(root);
        
        return cur;
    }
}