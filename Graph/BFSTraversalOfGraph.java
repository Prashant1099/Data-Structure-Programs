// Question Link: https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1/#

/* Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
Note: One can move from node u to node v only if there's an edge from u to v and find the BFS traversal of the graph starting from the 0th vertex, from left to right according to the graph. Also, you should only take nodes directly or indirectly connected from Node 0 in consideration.
*/ 

import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.bfsOfGraph(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class BFSTraversalOfGraph
{
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        
        ArrayList<Integer> bfs = new ArrayList<>(); 
        boolean vis[] = new boolean[V]; 
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0); 
        vis[0] = true; 
        
        while (!q.isEmpty())
        {
            Integer node = q.poll();
            bfs.add(node); 
 
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for(Integer it: adj.get(node)) {
                if(vis[it] == false) {
                    vis[it] = true; 
                    q.add(it); 
                } 
            }
        }
        
        return bfs; 
    }
}