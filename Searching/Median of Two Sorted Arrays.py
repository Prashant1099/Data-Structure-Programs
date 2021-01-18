# Question Link (Leetcode): https://leetcode.com/problems/median-of-two-sorted-arrays/

'''
Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

Follow up: The overall run time complexity should be O(log (m+n)).
'''

class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        m, n = len(nums1), len(nums2)
        
        if m == 0:
            mid = n >> 1
            if n%2 == 0:
                return (nums2[mid]+nums2[mid-1])/2
            else:
                return nums2[mid]
        
        gap = self.nextGap(m+n)
        
        while gap > 0:
            i = 0
            while i+gap < m:
                if nums1[i] > nums1[i+gap]:
                    nums1[i], nums1[i+gap] = nums1[i+gap], nums1[i]
                i += 1
            
            j = gap-m if gap > m else 0
            while i < m and j < n:
                if nums1[i] > nums2[j]:
                    nums1[i], nums2[j] = nums2[j], nums1[i]
                i += 1
                j += 1
            
            if j < n:
                j = 0
                while j+gap < n:
                    if nums2[j] > nums2[j+gap]:
                        nums2[j], nums2[j+gap] = nums2[j+gap], nums2[j]
                    j += 1
        
            gap = self.nextGap(gap)
        
        if m == n:
            return (nums1[m-1]+nums2[0])/2
        
        mid = (m+n)>>1
        
        if mid <= m-1:
            if (m+n)%2 == 0:
                median = (nums1[mid]+nums1[mid-1])/2
            else:
                median = nums1[mid]
        else:
            if (m+n)%2 == 0:
                median = (nums2[mid-m]+nums2[(mid-m)-1])/2
            else:
                median = nums2[mid-m]
        
        return median
    
    def nextGap(self, n):
        if n <= 1:
            return 0
        return (n//2) + (n%2)


t = int(input())
while t>0:
    obj = Solution()
    nums1 = [int(x) for x in input().split()]
    nums2 = [int(x) for x in input().split()]
    ans = obj.findMedianSortedArrays(nums1, nums2)
    print(ans)
    t -= 1