// Question Link: https://practice.geeksforgeeks.org/problems/rod-cutting0840/1/#

/* Given a rod of length N inches and an array of prices, price[] that contains prices of all pieces of size smaller than N. Determine the maximum value obtainable by cutting up the rod and selling the pieces.
*/

// { Driver Code Starts


    import java.io.*;
    import java.util.*;
    
    class RodCutting {
    
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
    
                RodCuttingProblem ob = new RodCuttingProblem();
                System.out.println(ob.cutRod(arr, n));
            }
            sc.close();
        }
    }
    // } Driver Code Ends
    
    
    class RodCuttingProblem{
        public int cutRod(int price[], int n) {
            int [][]dp = new int[n+1][n+1];
            
            int []length = new int[n];
            for(int i=0; i<n; i++) length[i] = i+1;
            
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(length[i-1] <= j){
                        dp[i][j] = Math.max(price[i-1]+dp[i][j-length[i-1]], dp[i-1][j]);
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            
            return dp[n][n];
        }
    }