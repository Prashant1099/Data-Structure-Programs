# Question Link (Leetcode): https://leetcode.com/problems/search-in-rotated-sorted-array/

'''
Search in Rotated Sorted Array

You are given an integer array nums sorted in ascending order (with distinct values), and an integer target. Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). If target is found in the array return its index, otherwise, return -1.
'''

class Solution:
    def search(self, nums, target):
        if not nums: 
            return -1
        
        start, end = 0, len(nums)-1
        
        while start < end:
            mid = start + (end-start)//2
            if target == nums[mid]: 
                return mid

            if nums[start] < nums[mid]:
                if nums[start] <= target <= nums[mid]: 
                    end = mid
                else: 
                    start = mid+1
            else: 
                if nums[mid+1] <= target <= nums[end]: 
                    start = mid+1
                else: 
                    end = mid
        return start if nums[start] == target else -1

t = int(input())
while t>0:
    obj = Solution()
    nums = [int(x) for x in input().split()]
    target = int(input())
    ans = obj.search(nums, target)
    print(ans)
    t -= 1