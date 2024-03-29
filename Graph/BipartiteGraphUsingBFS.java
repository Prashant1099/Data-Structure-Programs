// Question Link: https://practice.geeksforgeeks.org/problems/bipartite-graph/1/#

/* Given an adjacency list of a graph adj  of V no. of vertices having 0 based index. Check whether the graph is bipartite or not.
*/

// { Driver Code Starts
import java.util.*;
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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            BipartiteGraphUsingBFS obj = new BipartiteGraphUsingBFS();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}// } Driver Code Ends


class BipartiteGraphUsingBFS
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int []colour = new int[V];
        Arrays.fill(colour, -1);
        
        for(int i=0; i<V; i++){
            if(colour[i] == -1){
                if(checkBipartite(i, colour, adj) == false) return false;
            }
        }
        
        return true;
    }
    
    public boolean checkBipartite(int i, int []colour, ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        colour[i] = 0;
        
        while(!queue.isEmpty()){
            Integer node = queue.poll();
            
            for(Integer it : adj.get(node)){
                if(colour[it] == -1){
                    colour[it] = 1-colour[node];
                    queue.add(it);
                }
                else if(colour[it] == colour[node]) return false;
            }
        }
        
        return true;
    }
}