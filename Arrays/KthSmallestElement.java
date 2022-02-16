// Question Link: https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1

/* Given an array arr[] and an integer K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.
*/

// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    KthSmallestElement ob = new KthSmallestElement();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}
// } Driver Code Ends


//User function Template for Java

class KthSmallestElement{
    public int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        if(k>0 && k <= r-l+1){
            int pos = partitioning(arr, l, r);
    
            if(pos-l == k-1) return arr[pos];
            else if(pos-l < k-1) return kthSmallest(arr, pos+1, r, k-pos+l-1);
            else return kthSmallest(arr, l, pos-1, k);
        }
        
        return Integer.MAX_VALUE;
    } 

    public static int partitioning(int[] arr, int l, int r){
        int pos = l;
        int pivot = arr[r];

        for(int i=l; i<r; i++){
            if(arr[i] <= pivot){
                int temp = arr[i];
                arr[i] = arr[pos];
                arr[pos] = temp;

                pos++;
            }
        }

        int temp = arr[pos];
        arr[pos] = arr[r];
        arr[r] = temp;

        return pos;
    }
}