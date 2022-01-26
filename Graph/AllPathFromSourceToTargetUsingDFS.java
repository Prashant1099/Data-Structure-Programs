import java.util.ArrayList;
import java.util.List;

// Question Link: https://leetcode.com/problems/all-paths-from-source-to-target/

/* Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
*/

class AllPathFromSourceToTargetUsingDFS {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> subList = new ArrayList<>();
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        
        if(n == 0) return ans;
        
        boolean []visit = new boolean[n];
        
        dfs(0, n-1, visit, graph);
            
        return ans;
    }
    
    public void dfs(int cur, int target, boolean []visit, int[][] graph){
        subList.add(cur);
        visit[cur] = true;
        
        if(cur == target){
            List<Integer> completePath = new ArrayList<>(subList);
            ans.add(completePath);
        }
        else{
            for(int it : graph[cur]){
                if(!visit[it]){
                    dfs(it, target, visit, graph);
                }
            }
        }
        
        visit[cur] = false;
        subList.remove(subList.size()-1);
    }
}