// Question Link: https://leetcode.com/problems/single-number/

/* Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.
*/

// Method 1
class SingleNumberProblem{
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-1; i+=2){
            if(nums[i] != nums[i+1]) return nums[i];
        }
        
        return nums[nums.length-1];
    }
}

}
// Method 2 (Naive Approach)
class SingleNumberProblem1 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        
        for(int i : nums){
            if(hashMap.containsKey(i)){
                hashMap.put(i, hashMap.get(i)+1);
            }
            else{
                hashMap.put(i, 1);
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()){
            if(entry.getValue() == 1) return entry.getKey();
        }
        
        return Integer.MAX_VALUE;   
    }
}