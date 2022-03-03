// Question Link: https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/

/* An array contains both positive and negative numbers in random order. Rearrange the array elements so that all negative numbers appear before all positive numbers.
*/

class MoveNegativeElements{
    public int[] rearrage(int []arr, int n){
        int i=0, neg=0;
		
		while(i < n){
		    if(arr[i] < 0){
		        int temp = arr[i];
		        arr[i] = arr[neg];
		        arr[neg] = temp;
		        
		        i++;
		        neg++;
		    }
		    else i++;
		}

        return arr;
    }
}