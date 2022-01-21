import java.util.ArrayList;

// Question Link: https://www.interviewbit.com/problems/path-to-given-node/

/* Given a Binary Tree A containing N nodes.

You need to find the path from Root to a given node B.

NOTE:
    - No two nodes in the tree have same data values.
    - You can assume that B is present in the tree A and a path always exists.
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

public class PathToGivenRoot {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();

        treeTraversal(A, B, ans);

        return ans;
    }

    public boolean treeTraversal(TreeNode node, int B, ArrayList<Integer> ans){
        if(node == null) return false;
        
        ans.add(node.val);

        if(node.val == B) return true;

        
        if(treeTraversal(node.left, B, ans) || treeTraversal(node.right, B, ans)) return true;
        ans.remove(ans.size()-1);

        return false;
    }
}
