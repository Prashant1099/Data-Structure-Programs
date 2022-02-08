// Question Link: https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1/#

/* Given a sequence of matrices, find the most efficient way to multiply these matrices together. The efficient way is the one that involves the least number of multiplications.

The dimensions of the matrices are given in an array arr[] of size N (such that N = number of matrices + 1) where the ith matrix has the dimensions (arr[i-1] x arr[i]).
*/ 

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            MatrixChainMultiplicationProblem ob = new MatrixChainMultiplicationProblem();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class MatrixChainMultiplicationProblem{
    private static int [][]dp = new int[101][101];
    int matrixMultiplication(int N, int arr[])
    {
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return solve(1, N-1, arr);
    }
    
    static int solve(int i, int j, int[] arr){
        if(i >= j) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int minCost = Integer.MAX_VALUE;
        
        for(int k=i; k<j; k++){
            int temp = solve(i, k, arr) + solve(k+1, j, arr) + (arr[i-1]*arr[k]*arr[j]);
            
            minCost = temp < minCost ? temp : minCost;
        }
        
        dp[i][j] = minCost;
        return minCost;
    }
}