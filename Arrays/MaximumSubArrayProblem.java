// Question Link: https://leetcode.com/problems/maximum-subarray/

/* Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.
*/

class MaximumSubArrayProblem {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = nums[0];
        
        for(int i=0; i<nums.length; i++){
            currSum += nums[i];
            maxSum = currSum > maxSum ? currSum : maxSum;
            currSum = currSum < 0 ? 0 : currSum;
        }
        
        return maxSum;
    }
}