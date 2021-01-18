# Question Link(Leetcode): https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

'''
Find Minimum in Rotated Sorted Array II

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand. (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element. The array may contain duplicates.
'''

class Solution:
    def findMin(self, nums):
        if len(nums) == 1:
            return nums[0]
        
        start, end = 0, len(nums)-1
        
        while start <= end:
            mid = start + (end-start)//2
            
            if nums[mid] < nums[mid-1]:
                return nums[mid]
            else:
                if nums[mid] > nums[end]:
                    start = mid+1
                else:
                    if nums[mid] < nums[end]:
                        end = mid-1
                    else:
                        end -= 1
                    
                
        return nums[start]

t = int(input())
while t>0:
    obj = Solution()
    nums = [int(x) for x in input().split()]
    ans = obj.findMin(nums)
    print(ans)
    t -= 1