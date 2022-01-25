// Question Link: https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1/

/* Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. 
*/

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            DetectCycleInUndirectedGraphUsingBFS obj = new DetectCycleInUndirectedGraphUsingBFS();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


class Pair{
    int node;
    int parent;
    
    public Pair(int node, int parent){
        this.node = node;
        this.parent = parent;
    }
}
class DetectCycleInUndirectedGraphUsingBFS {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean []visit = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(visit[i] == false){
                if(checkCycle(i, visit, adj)) return true;
            }
        }
        
        return false;
    }
    
    public boolean checkCycle(int i, boolean []visit, ArrayList<ArrayList<Integer>> adj){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, -1));
        visit[i] = true;
        
        while(!queue.isEmpty()){
            int node = queue.peek().node;
            int parent = queue.peek().parent;
            queue.poll();
            
            for(Integer it : adj.get(node)){
                if(visit[it] == false){
                    visit[it] = true;
                    queue.add(new Pair(it, node));
                }
                else if(parent != it) return true;
            }
        }
        
        return false;
    }
}