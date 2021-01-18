# Question Link(Leetcode): https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

'''
Find Minimum in Rotated Sorted Array

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
    [4,5,6,7,0,1,2] if it was rotated 4 times.
    [0,1,2,4,5,6,7] if it was rotated 7 times.

Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums, return the minimum element of this array.
'''

class Solution:
    def findMin(self, nums):
        start, end = 0, len(nums)-1
        
        while start <= end:
            mid = start + (end-start)//2
            
            if nums[mid] <= nums[end]:
                if nums[mid] > nums[mid-1]:
                    end = mid-1
                else:
                    return nums[mid]
            else:
                start = mid+1
            
        return nums[mid]

t = int(input())
while t>0:
    obj = Solution()
    nums = [int(x) for x in input().split()]
    ans = obj.findMin(nums)
    print(ans)
    t -= 1