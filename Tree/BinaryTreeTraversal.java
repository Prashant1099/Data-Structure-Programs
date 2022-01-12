// Preorder Inorder Postorder Traversals of any Binary Tree in One Traversal

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreeTraversal {
    public void traversal(TreeNode root){
        Stack<Pair> stack = new Stack<Pair>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        if(root == null) return;

        stack.push(root, 1);

        while(!stack.isEmpty()){
            Pair it = stack.pop();

            if(it.num == 1){
                preorder.add(it.node.val);
                it.num++;
                stack.push(it);

                if(it.node.left != null){
                    stack.push(new Pair(it.node.left, 1));
                }
            }
            else if(it.num == 2){
                inorder.add(it.node.val);
                it.num++;
                stack.push(it);

                if(it.node.right != null){
                    stack.push(new Pair(it.node.right, 1));
                }
            }
            else{
                postorder.add(it.node.val);
            }
        }
    }
}
