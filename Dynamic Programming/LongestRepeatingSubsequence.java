// Question Link: https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1#

/* Given a string str, find the length of the longest repeating subsequence such that it can be found twice in the given string. The two identified subsequences A and B can use the same ith character from string str if and only if that ith character has different indices in A and B.
*/ 

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            LongestRepeatingSubsequence ob = new LongestRepeatingSubsequence();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class LongestRepeatingSubsequence
{
    public int LongestRepeatingSubsequence(String str)
    {
        int n = str.length();
        int [][]dp = new int[n+1][n+1];
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(str.charAt(i-1) == str.charAt(j-1) && i != j){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        
        return dp[n][n];
    }
}