# Question Link (GFG): https://practice.geeksforgeeks.org/problems/count-squares3649/1

'''
Square root of an integer

Given an integer x, find it’s square root. If x is not a perfect square, then return floor(√x).
'''

def squareRoot(n):
    start = 1
    end = n
    ans = 0

    while start <= end:
        mid = start + (end-start)//2

        if mid*mid < n:
            ans = mid
            start = mid+1
        else:
            end = mid-1
    
    return ans

t = int(input())
while t>0:
    n = int(input())
    print(squareRoot(n))
    t -= 1