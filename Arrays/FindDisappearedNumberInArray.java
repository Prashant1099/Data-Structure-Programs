import java.util.ArrayList;
import java.util.List;

// Question Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

/* Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
*/

class FindDisappearedNumbersInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0) nums[index] *= -1;
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0) ans.add(i+1);
        }
        
        return ans;
    }
}