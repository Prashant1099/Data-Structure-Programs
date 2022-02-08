// Question Link: https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1/#

/* Given two strings str1 and str2. The task is to remove or insert the minimum number of characters from/in str1 so as to transform it into str2. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.
*/

// Driver Code Starts
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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    MinNumberOfDeletionAndInsertion ob = new MinNumberOfDeletionAndInsertion();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    // Driver Code Ends


//User function Template for Java

class MinNumberOfDeletionAndInsertion
{
	public int minOperations(String str1, String str2) 
	{ 
	    int m = str1.length();
	    int n = str2.length();
	    
	    int lcs = longestCommonSubsequence(str1, str2, m, n);
	    
	    return (n-lcs) + (m-lcs);
	} 
	
	public int longestCommonSubsequence(String str1, String str2, int m, int n){
	    int dp[][] = new int[m+1][n+1];
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[m][n];
	}
}