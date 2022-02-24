import java.util.Arrays;

// Question Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

/* Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
*/

// Method 1
class FindMissingNumberInArray {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        int sumUptoN = (n*(n+1))/2;
        
        for(int i : nums){
            sumUptoN -= i;
        }
        
        return sumUptoN;
    }
}

// Method 2 (Naive Approach)
class FindMissingNumberInArray2 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        int []hashMap = new int[n+1];
        Arrays.fill(hashMap, -1);
        
        for(int i=1; i<=n; i++){
            hashMap[nums[i-1]] = nums[i-1];
        }
        
        for(int i=0; i<=n; i++){
            if(hashMap[i] == -1) return i;
        }
        
        return 0;
    }
}