// Question Link: https://leetcode.com/problems/longest-common-subsequence/

/* Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
*/

class LongestCommonSubsequenceUsingTopDown {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int t[][] = new int[n+1][m+1];

        for(int i=0; i<n+1; i++)
            for(int j=0; j<m+1; j++)
                if(i == 0 || j == 0)
                    t[i][j] = 0;

        for(int i=1; i<n+1; i++)
            for(int j=1; j<m+1; j++)
            {
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];

                else
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
            }

        return t[n][m];
    }
}