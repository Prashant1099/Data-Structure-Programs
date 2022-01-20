import java.util.Stack;

// Question Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/

/* Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
*/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */

public class KthSmallestElementInBST {
    public int kthsmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;

        while(true){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else{
                if(stack.isEmpty()) break;
                node = stack.pop();
                k -= 1;

                if(k == 0) return node.val;
                node = node.right;
            }
        }

        return -1;
    }
}
