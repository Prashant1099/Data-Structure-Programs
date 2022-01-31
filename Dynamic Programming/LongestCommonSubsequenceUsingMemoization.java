import java.util.Arrays;

// Question Link: https://leetcode.com/problems/longest-common-subsequence/

/* Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
*/

class LongestCommonSubsequenceUsingMemoization {
    private static int [][]dp = new int[1001][1001];
    public int longestCommonSubsequence(String text1, String text2) {
        for(int []rows : dp){
            Arrays.fill(rows, -1);
        }
        
        return lcs(text1, text2, text1.length(), text2.length());
    }
    
    public int lcs(String text1, String text2, int n, int m){
        if(n == 0 || m == 0) return 0;
        
        if(text1.charAt(n-1) == text2.charAt(m-1)){
            return dp[n][m] = 1 + lcs(text1, text2, n-1, m-1);
        }
        else{
            return dp[n][m] = Math.max(lcs(text1, text2, n-1, m), lcs(text1, text2, n, m-1));
        }
    }
}