// Question Link: https://practice.geeksforgeeks.org/problems/ncr1019/1#

/* Given two integers n and r, find nCr. Since the answer may be very large, calculate the answer modulo 10^9+7. */

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            BinomialCoefficientProblem ob = new BinomialCoefficientProblem();
            System.out.println(ob.nCr(n, r));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class BinomialCoefficientProblem{
    int nCr(int n, int r)
    {
        int [][]dp = new int[n+1][r+1];
        int m = (int)10e9 + 7;
        
        for(int i=0; i<=n; i++){
            for(int j=0; j<=r; j++){
                if(j == 0 || j == i) dp[i][j] = 1;
                else if(j > i) dp[i][j] = 0;
                else dp[i][j] = (dp[i-1][j-1]%m + dp[i-1][j]%m)%m;
            }
        }
        
        return dp[n][r]%m;
    }
}
