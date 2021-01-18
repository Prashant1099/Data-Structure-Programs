# Question Link (Leetcode): https://leetcode.com/problems/powx-n/

'''
Pow(x, n)

Implement pow(x, n), which calculates x raised to the power n.
'''

class Solution:
    def myPow(self, x, n):
        if n == 0:
            return 1
        elif n < 0:
            power = self.calculatePower(x, -n)
            return 1/power
        else:
            power = self.calculatePower(x, n)
            return power
    
    def calculatePower(self, x, n):
        if n == 1:
            return x
        
        if n%2 == 0:
            return self.calculatePower(x*x, n//2)
        else:
            return x * self.calculatePower(x, n-1)

t = int(input())
while t>0:
    obj = Solution()
    x, n = [float(x) for x in input().split()]
    ans = obj.myPow(x, n)
    print(ans)
    t -= 1
    