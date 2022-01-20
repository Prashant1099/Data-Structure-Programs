// Question Link: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/submissions/

/* Given a binary search tree A, where each node contains a positive integer, and an integer B, you have to find whether or not there exist two different nodes X and Y such that X.value + Y.value = B.

Return 1 to denote that two such nodes exist. Return 0, otherwise.
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

public class TwoSumBinarySearchTree {
    public int t2Sum(TreeNode A, int B) {
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = A;

        while(true){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else{
                if(stack.isEmpty()) break;
                node = stack.pop();
                inorder.add(node.val);
                node = node.right;
            }
        }    

        int start = 0, end = inorder.size()-1;

        while(start < end){
            if(inorder.get(start) + inorder.get(end) == B) return 1;
            else if(inorder.get(start) + inorder.get(end) > B) end--;
            else start ++;
        }

        return 0;
    }
}
