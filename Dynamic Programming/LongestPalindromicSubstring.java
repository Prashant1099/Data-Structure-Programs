// Question Link: https://practice.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1/

/* Given a string S, find the longest palindromic subsequence's length in S.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
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
                    String s = sc.next();
                    LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}// } Driver Code Ends


//User function Template for Java

class LongestPalindromicSubstring
{
    public int longestPalinSubseq(String S)
    {
        int n = S.length();
        
        String S2 = reverse(S, n);
        
        return longestCommonSubsequence(S, S2, n);
    }
    
    public String reverse(String S, int n){
        String str = "";
        
        for(int i=n-1; i>=0; i--) str += S.charAt(i);
        
        return str;
    }
    
    public int longestCommonSubsequence(String str1, String str2, int n){
        int [][]dp = new int[n+1][n+1];
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[n][n];
    }
}