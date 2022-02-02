// Question Link: https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1/#

/* Given an integer array arr of size N, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum and find the minimum difference
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
                int A[] = new int[n];
                for(int i = 0;i<n;i++)
                    A[i] = sc.nextInt();
                MinimumSumPartition ob = new MinimumSumPartition();
                System.out.println(ob.minDifference(A,n));
            }
            sc.close();
        }
}    // } Driver Code Ends


//User function Template for Java

class MinimumSumPartition
{

	public int minDifference(int arr[], int n){ 
	    int sum = 0;
	    for(int i=0; i<n; i++){
	        sum += arr[i];
	    }
	    
	    int i;
	    for(i=0; i<=sum; i++){
	        float targetSum = (sum-i)/(float)2;
	        if((int)targetSum == targetSum){
	            if(subsetSum(arr, n, (int)targetSum)) break;
	        }
	    }
	    
	    return i;
	}
	
	public boolean subsetSum(int arr[], int n, int sum){
	    boolean [][]dp = new boolean[n+1][sum+1];
	    
	    for(int i=0; i<=sum; i++){
	        dp[0][i] = false;
	    }
	    
	    for(int i=0; i<=n; i++){
	        dp[i][0] = true;
	    }
	    
	    for(int i=1; i<=n; i++){
	        for(int j=1; j<=sum; j++){
	            if(arr[i-1] <= j){
	                dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
	            }
	            else{
	                dp[i][j] = dp[i-1][j];
	            }
	        }
	    }
	    
	    return dp[n][sum];
	}
}
