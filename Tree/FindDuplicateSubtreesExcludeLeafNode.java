// Question Link: https://practice.geeksforgeeks.org/problems/duplicate-subtree-in-binary-tree/1/#

/* Given a binary tree, find out whether it contains a duplicate sub-tree of size two or more, or not.
*/

// { Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
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

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
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
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
	    	Node root = buildTree(s);
	    	
            FindDuplicateSubtreesExcludeLeafNode ob = new FindDuplicateSubtreesExcludeLeafNode();
    		System.out.println(ob.dupSub(root));
            t--;
        }
    }
}// } Driver Code Ends


//User function Template for Java

/* A Binary Tree node

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */

class FindDuplicateSubtreesExcludeLeafNode {
    int dupSub(Node root) {
        Map<String, Integer> map = new HashMap<>();
        
        int[] count = new int[1];
        count[0] = 0;
        duplicateSubTree(root, count, map);
        
        return count[0];
    }
    
    String duplicateSubTree(Node node, int[] count, Map<String, Integer> map){
        if(node == null) return "N";
        
        String left = duplicateSubTree(node.left, count, map);
        String right = duplicateSubTree(node.right, count, map);
        
        String cur = node.data + " " + left + " " + right;
        
        if(node.left != null && node.right != null){
            map.put(cur, map.getOrDefault(cur, 0)+1);
        
            if(map.get(cur) > 1 && cur.length() > 5) count[0] += 1;
        }
        return cur;
    }
}
