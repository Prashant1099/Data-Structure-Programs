// Question Link: https://leetcode.com/problems/rotate-array/

// Given an array, rotate the array to the right by k steps, where k is non-negative.

class RotateArrayByKsteps {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        k = n-k;
        int gcd = gcd(n, k);
        
        for(int i=0; i<gcd; i++){
            int temp = nums[i];
            int j = i;
            while(true){
                int jump = (j+k)%n;
                if(jump == i) break;
                nums[j] = nums[jump];
                j = jump;
            }
            nums[j] = temp;
        }
    }
    
    public int gcd(int n, int k){
        if(k == 0) return n;
        return gcd(k, n%k);
    }
}