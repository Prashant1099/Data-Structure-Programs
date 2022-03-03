import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Question Link: https://leetcode.com/problems/intersection-of-two-arrays/

/* Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
*/

class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int m = nums1.length, n = nums2.length;
        int i=0, j=0;
        
        Set<Integer> list = new HashSet<>();
        
        while(i<m && j<n){
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]) i++;
            else j++;
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