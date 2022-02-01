// Question Link: https://practice.geeksforgeeks.org/problems/minimum-cost-to-fill-given-weight-in-a-bag1956/1#

/* Given an array cost[] of positive integers of size N and an integer W, cost[i] represents the cost of ‘i’ kg packet of oranges, the task is to find the minimum cost to buy W kgs of oranges. If it is not possible to buy exactly W kg oranges then the output will be -1

Note:
1. cost[i] = -1 means that ‘i’ kg packet of orange is unavailable
2. It may be assumed that there is infinite supply of all available packet types.
*/

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
            {
                int n = sc.nextInt();
                int w = sc.nextInt();
                int cost[] = new int[n];
                for(int i = 0;i<n;i++)
                    cost[i] = sc.nextInt();
                MinimumCostToFillGivenWtInBag ob = new MinimumCostToFillGivenWtInBag();
                System.out.println(ob.minimumCost(cost,n,w));
            }
            sc.close();
        }
}    // } Driver Code Ends


class MinimumCostToFillGivenWtInBag
{
	public int minimumCost(int cost[], int N,int W)
	{
		int [][]dp = new int[N+1][W+1];
		
        for(int i=0; i<=W; i++){
            dp[0][i] = 1000000007;
        }
        
        for(int i=0; i<=N; i++){
            dp[i][0] = 0;
        }
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=W; j++){
                if(i <= j){
                    if(cost[i-1] != -1){
                        dp[i][j] = Math.min(cost[i-1] + dp[i][j-i], dp[i-1][j]);
                    }
                    else dp[i][j] = dp[i-1][j];
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[N][W] == 1000000007 ? -1 : dp[N][W];
	}
}