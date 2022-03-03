// Question Link: https://practice.geeksforgeeks.org/problems/union-of-two-arrays3538/1

/* Given two integer arrays nums1 and nums2, return an array of their union. Each element in the result must be unique and you may return the result in any order.
*/

class UnionOfTwoArrays {
    public int[] union(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int m = nums1.length, n = nums2.length;
        int i=0, j=0;
        
        List<Integer> list = new ArrayList<>();
        
        while(i<m && j<n){
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]){
                list.add(nums1[i]);
                i++;
            }
            else{
                list.add(nums2[j]);
                j++;
            } 
        }
        
        int []ans = new int[list.size()];
        int k=0;
        for(Integer it : list){
            ans[k] = it;
            k++;
        }
        
        return ans;
    }
}