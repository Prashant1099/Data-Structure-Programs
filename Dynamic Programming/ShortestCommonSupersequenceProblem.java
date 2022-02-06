// Question Link: https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1/#

/* Given two strings X and Y of lengths m and n respectively, find the length of the smallest string which has both, X and Y as its sub-sequences.
Note: X and Y can have both uppercase and lowercase letters.
*/

// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new ShortestCommonSupersequenceProblem().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}      
}// } Driver Code Ends


//User function Template for Java

class ShortestCommonSupersequenceProblem
{
    public int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        int lcs = longestCommonSubsequence(X, Y, m, n);
        
        return (m+n)-lcs;
    }
    
    public static int longestCommonSubsequence(String X,String Y,int m,int n){
        int dp[][] = new int[m+1][n+1];
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(X.charAt(i-1) == Y.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[m][n];
    }
}