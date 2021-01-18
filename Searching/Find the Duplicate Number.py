# Question Link(Leetcode): https://leetcode.com/problems/find-the-duplicate-number/

'''
Find the Duplicate Number

Given an array of integers nums containing n+1 integers where each integer is in the range [1, n] inclusive. There is only one repeated number in nums, return this repeated number.
'''

class Solution:
    def findDuplicate(self, nums):
        slow = nums[0]
        fast = nums[0]
        
        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            
            if slow == fast:
                break
        
        fast = nums[0]
        
        while slow != fast:
            slow = nums[slow]
            fast = nums[fast]
        
        return slow
    
t = int(input())
while t>0:
    obj = Solution()
    nums = [int(x) for x in input().split()]
    ans = obj.findDuplicate(nums)
    print(ans)
    t -= 1
