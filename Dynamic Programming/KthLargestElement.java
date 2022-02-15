// Question Link: https://leetcode.com/problems/kth-largest-element-in-an-array/

/* Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.
*/

class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int target = n-k;
        
        int start=0, end=n-1;
        
        while(start < end){
            int pos = partitioning(nums, start, end);
            
            if(pos == target) break;
            else if(pos < target) start = pos+1;
            else end = pos-1;
        }
        
        return nums[target];
    }
    
    public int partitioning(int[] nums, int start, int end){
        int pos = start; 
        int pivot = nums[end];
        
        for(int i=start; i<end; i++){
            if(nums[i] <= pivot){
                swap(nums, i, pos);
                pos++;
            }
        }
        
        swap(nums, pos, end);
        
        return pos;
    }
    
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}