# Question Link (Leetcode): https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

'''
Search in Rotated Sorted Array II

You are given an integer array nums sorted in ascending order (not necessarily distinct values), and an integer target. Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,4,4,5,6,6,7] might become [4,5,6,6,7,0,1,2,4,4]). If target is found in the array return its index, otherwise, return -1.
'''

class Solution:
    def search(self, nums, target):
        begin = 0
        end = len(nums) - 1 

        while begin <= end:
            mid = (begin + end)//2
            if nums[mid] == target:
                return True
            if nums[mid] == nums[end]:                              # Fail to estimate which side is sorted
                end -= 1                                            # In worst case: O(n)
            elif nums[mid] > nums[end]:                             # Left side of mid is sorted
                if  nums[begin] <= target and target < nums[mid]:   # Target in the left side
                    end = mid - 1
                else:                                               # in right side
                    begin = mid + 1
            else:                                                   # Right side is sorted
                if  nums[mid] < target and target <= nums[end]:     # Target in the right side
                    begin = mid + 1
                else:                                               # in left side
                    end = mid - 1
        return False

t = int(input())
while t>0:
    obj = Solution()
    nums = [int(x) for x in input().split()]
    target = int(input())
    ans = obj.search(nums, target)
    print(ans)
    t -= 1