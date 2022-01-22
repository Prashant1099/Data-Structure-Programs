import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// Question Link: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

/* Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class AllNodeDistanceKBinaryTree {
    public void markParents(TreeNode root, Map<TreeNode, TreeNode> parent){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                queue.offer(node.left);
                parent.put(node.left, node);
            }
            if(node.right != null){
                queue.offer(node.right);
                parent.put(node.right, node);
            }
        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        markParents(root, parent);
        
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        visited.put(target, true);
        queue.offer(target);
        
        int level = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            if(level == k) break;
            
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.left != null && visited.get(node.left) == null){
                    queue.offer(node.left);
                    visited.put(node.left, true);
                }
                if(node.right != null && visited.get(node.right) == null){
                    queue.offer(node.right);
                    visited.put(node.right, true);
                }
                if(parent.get(node) != null && visited.get(parent.get(node)) == null){
                    queue.offer(parent.get(node));
                    visited.put(parent.get(node), true);
                }
            }
            
            level++;
        }
        
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            ans.add(node.val);
        }
        
        return ans;
    }
}