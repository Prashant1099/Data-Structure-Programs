// Question Link: https://practice.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1

/* Given an array, rotate the array by one position in clock-wise direction. */

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            RotateArrayByOne obj = new RotateArrayByOne();
            obj.rotate(a, n);
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n;i++)
                output.append(a[i]+" ");
            System.out.println(output);
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class RotateArrayByOne {
    public void rotate(int arr[], int n)
    {
        int temp = arr[n-1];
        
        for(int i=n-1; i>0; i--){
            arr[i] = arr[i-1];
        }
        
        arr[0] = temp;
    }
}