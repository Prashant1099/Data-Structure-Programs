// Question Link: https://leetcode.com/problems/edit-distance/

/* Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:
    - Insert a character
    - Delete a character
    - Replace a character
*/

class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int [][]dp = new int[m+1][n+1];
        
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i == 0) dp[i][j] = j;
                else if(j == 0) dp[i][j] = i;
                else if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int replace = 1 + dp[i-1][j-1];
                    int insert = 1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j];
                    
                    dp[i][j] = Math.min(replace, Math.min(insert, delete));
                }
            }
        }
        
        return dp[m][n];
    }
}