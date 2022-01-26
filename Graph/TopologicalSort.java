// Question Link: https://practice.geeksforgeeks.org/problems/topological-sort/1/#

/* Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph. */

// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new TopologicalSort().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends


/*Complete the function below*/


class TopologicalSort
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        Stack<Integer> stack = new Stack<>();
        boolean visit[] = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(!visit[i]) dfsTraversal(i, visit, stack, adj);
        }
        
        int []ans = new int[V];
        
        int i=0;
        while(!stack.isEmpty()){
            ans[i++] = stack.pop();
        }
        
        return ans;
    }
    
    static void dfsTraversal(int node, boolean []visit, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj){
        visit[node] = true;
        
        for(Integer it : adj.get(node)){
            if(!visit[it]) dfsTraversal(it, visit, stack, adj);
        }
        
        stack.push(node);
    }
}
