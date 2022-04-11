// Question Link: https://leetcode.com/problems/two-sum/

/* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
*/

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        
        Map<Integer, Integer> hashMap = new HashMap<>();
        int []ans = new int[2];
        
        for(int i=0; i<n; i++){
            if(hashMap.containsKey(nums[i])){
                ans[0] = hashMap.get(nums[i]);
                ans[1] = i;
            }
            else{
                int diff = target-nums[i];
                hashMap.put(diff, i);
            }
        }
        
        return ans;
    }
}