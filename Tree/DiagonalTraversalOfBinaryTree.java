// Question Link: https://practice.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1/#

/* Given a Binary Tree, print the diagonal traversal of the binary tree.

Consider lines of slope -1 passing between nodes. Given a Binary Tree, print all diagonal elements in a binary tree belonging to same line.
*/

// { Driver Code Starts
//Initial Template for Java
import java.util.LinkedList; 
import java.util.Deque; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the deque
        
        Deque<Node> deque = new LinkedList<>(); 
        
        deque.add(root);
        // Starting from the second element
        
        int i = 1;
        while(deque.size()>0 && i < ip.length) {
            
            // Get and remove the front of the deque
            Node currNode = deque.peek();
            deque.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the deque
                deque.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the deque
                deque.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        DiagonalTraversalOfBinaryTree g = new DiagonalTraversalOfBinaryTree();
			    ArrayList<Integer> diagonalNode = g.diagonal(root);
			    for(int i = 0 ;i<diagonalNode.size();i++){
			        System.out.print(diagonalNode.get(i)+ " ");
			    }
		        System.out.println();
	        }
	}
}


// } Driver Code Ends


//User function Template for Java

/* Node is defined as
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/

class DiagonalTraversalOfBinaryTree
{
    public ArrayList<Integer> diagonal(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        ArrayList<Integer> diagonalNode = new ArrayList<Integer>();
        while (!queue.isEmpty()){
            Node curr = queue.remove();

            while (curr != null){
				
                diagonalNode.add(curr.data);
                if (curr.left != null){
                    queue.add(curr.left);
                }

                curr = curr.right;
            }
        }
        return diagonalNode;
    }
}