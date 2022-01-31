// Question Link: https://leetcode.com/problems/partition-equal-subset-sum/

/* Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
*/ 

class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int N = nums.length;
        
        for(int i=0; i<N; i++){
            sum += nums[i];
        }
        
        if(sum%2 != 0) return false;
        
        return subsetSum(N, nums, sum/2);
    }
    
    public boolean subsetSum(int N, int []arr, int sum){
        boolean [][]dp = new boolean[N+1][sum+1];
        
        for(int i=0; i<=sum; i++){
            dp[0][i] = false;
        }
        
        for(int i=0; i<=N; i++){
            dp[i][0] = true;
        }
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=sum; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[N][sum];
    }
}