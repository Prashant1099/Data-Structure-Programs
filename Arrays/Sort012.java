// Question Link: https://leetcode.com/problems/sort-colors/

/* Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.
*/

class Sort012 {
    public void sortColors(int[] nums) {
        int zeroInd = 0, oneInd = 0, twoInd = nums.length-1;
        
        while(oneInd <= twoInd){
            if(nums[oneInd] == 0){
                swap(nums, zeroInd, oneInd);
                zeroInd++;
                oneInd++;
            }
            else if(nums[oneInd] == 1){
                oneInd++;
            }
            else{
                swap(nums, oneInd, twoInd);
                twoInd--;
            }
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}