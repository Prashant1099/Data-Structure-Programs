// Question Link: https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions4610/1/#

/* Given a string 'str' of size ‘n’. The task is to remove or delete the minimum number of characters from the string so that the resultant string is a palindrome. Find the minimum numbers of characters we need to remove.
Note: The order of characters should be maintained.
*/

// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            String str = read.readLine().strip();
            MinInsertionStepstoMakeStringPalindrome ob = new MinInsertionStepstoMakeStringPalindrome();
            long ans = ob.minDeletions(str, n); 
            System.out.println(ans);
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class MinInsertionStepstoMakeStringPalindrome 
{ 
    int minDeletions(String str, int n)
    {
        String str2 = reverse(str, n);

        int lcs = longestCommonSubsequence(str, str2, n);
        
        return n-lcs;
    }
    
    public String reverse(String s, int n){
        String str = "";
        
        for(int i=n-1; i>=0; i--) str += s.charAt(i);
        
        return str;
    }
    
    public int longestCommonSubsequence(String str1, String str2, int n){
        int dp[][] = new int[n+1][n+1];
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[n][n];
    }
} 