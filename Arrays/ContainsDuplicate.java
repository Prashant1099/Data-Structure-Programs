import java.util.HashSet;
import java.util.Set;

// Question Link: https://leetcode.com/problems/contains-duplicate/

/* Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
*/

/* Method 1
class ContainsDuplicateProblem{
    public boolean containsDuplicate(int[] nums){
        Set<Integer> set = new HashSet<>();
        
        for(int i : nums){
            if(!set.add(i)) return true;
        }
        
        return false;
    }
}
*/

// Method 2
class ContainsDuplicateProblem {
    public boolean containsDuplicate(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for(int i : nums){
            minVal = i < minVal ? i : minVal;
            maxVal = i > maxVal ? i : maxVal;
        }

        boolean []duplicateArr = new boolean[maxVal-minVal+1];

        for(int i : nums){
            if(duplicateArr[i-minVal]) return true;
            duplicateArr[i-minVal] = true;
        }

        return false;
    }
}