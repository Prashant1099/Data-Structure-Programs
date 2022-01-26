// Question Link: https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1/

/* Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not. */

// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new DetectCycleInDirectedGraphUsingDFS().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class DetectCycleInDirectedGraphUsingDFS {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean []visit = new boolean[V];
        boolean []dfsVis = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(visit[i] == false){
                if(checkCycle(i, visit, dfsVis, adj) == true) return true;
            }
        }
        
        return false;
    }
    
    public boolean checkCycle(int i, boolean []visit, boolean []dfsVis, ArrayList<ArrayList<Integer>> adj){
        visit[i] = true;;
        dfsVis[i] = true;
        
        for(Integer it : adj.get(i)){
            if(visit[it] == false){
                if(checkCycle(it, visit, dfsVis, adj) == true) return true;
            }
            else if(dfsVis[it] == true) return true;
        }
        
        dfsVis[i] = false;
        return false;
    }
}