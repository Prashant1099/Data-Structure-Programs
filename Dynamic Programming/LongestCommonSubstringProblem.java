// Question Link: https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1/#

/* Given two strings. The task is to find the length of the longest common substring. */

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            LongestCommonSubstringProblem ob = new LongestCommonSubstringProblem();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class LongestCommonSubstringProblem{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        int [][]dp = new int[n+1][m+1];
        int ans = 0;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(S1.charAt(i-1) == S2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        
        return ans;
    }
}