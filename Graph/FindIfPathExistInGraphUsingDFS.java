import java.util.ArrayList;

// Question Link: https://leetcode.com/problems/find-if-path-exists-in-graph/

/* There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
*/

class FindIfPathExistInGraphUsingDFS {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(edges.length == 0) return true;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        // creating adjacency matrix
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean []visit = new boolean[n];
        
        return dfs(source, destination, visit, adj);
    }
    
    public boolean dfs(int source, int destination, boolean []visit, ArrayList<ArrayList<Integer>> adj){
        visit[source] = true;
        
        for(Integer it : adj.get(source)){
            if(it == destination) return true;
            if(!visit[it]){
                if(dfs(it, destination, visit, adj)) return true;
            }
        }
        
        return false;
    }
}