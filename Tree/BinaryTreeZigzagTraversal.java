// Question Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

/* Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between). 
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

class BinaryTreeZigzagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        if(root == null) return ans;
        
        queue.offer(root);
        boolean leftToRight = true;
        
        while(!queue.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                
                if(leftToRight) subList.add(queue.poll().val);
                else subList.add(0, queue.poll().val);
            }
            
            leftToRight = !leftToRight;
            ans.add(subList);
        }
        
        return ans;
    }
}