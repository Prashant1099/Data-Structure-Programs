// Question Link: https://www.interviewbit.com/problems/remove-half-nodes/

/* Given a binary tree A with N nodes.

You have to remove all the half nodes and return the final binary tree.

NOTE:
    - Half nodes are nodes which have only one child.
    - Leaves should not be touched as they have both children as NULL.
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

public class RemoveHalfNodes {
    public TreeNode solve(TreeNode A) {
        if(A == null) return null;

        A.left = solve(A.left);
        A.right = solve(A.right);

        if(A.left == null && A.right == null) return A;

        if(A.left == null){
            TreeNode node = A.right;
            return node;
        } 
        if(A.right == null){
            TreeNode node = A.left;
            return node;
        }

        return A;
    }
}
