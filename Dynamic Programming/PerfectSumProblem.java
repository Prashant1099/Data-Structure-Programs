// Question Link: https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1#

/* Given an array arr[] of integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.

Note: Answer can be very large, so, output answer modulo 109+7
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
            int sum = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0;i<n;i++)
            arr[i] = sc.nextInt();
            
            PerfectSumProblem ob = new PerfectSumProblem();
            System.out.println(ob.perfectSum(arr,n,sum));
        }
    }
}    // } Driver Code Ends


class PerfectSumProblem{

	public int perfectSum(int arr[],int n, int sum){ 
	    int [][]dp = new int[n+1][sum+1];
	    int mod = 1000000007;
	    
	    for(int i=0; i<=sum; i++){
	        dp[0][i] = 0;
	    }
	    
	    for(int i=0; i<n; i++){
	        dp[i][0] = 1;
	    }
	    
	    for(int i=1; i<=n; i++){
	        for(int j=0; j<=sum; j++){
	            if(arr[i-1] <= j){
	                dp[i][j] = (dp[i-1][j-arr[i-1]]%mod + dp[i-1][j]%mod)%mod;
	            }
	            else{
	                dp[i][j] = dp[i-1][j];
	            }
	        }
	    }
	    
	    return dp[n][sum]%mod;
	} 
}