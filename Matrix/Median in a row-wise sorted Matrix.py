# Question Link(GFG): https://practice.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1

'''
Median in a row-wise sorted Matrix 

Given a row wise sorted matrix of size RxC where R and C are always odd, find the median of the matrix.
'''

from bisect import bisect_right

class Solution:
    def median(self, matrix, r, c):
        minEle = matrix[0][0]
        maxEle = 0
        
        for row in matrix:
            minEle = min(minEle, row[0])
            maxEle = max(maxEle, row[-1])
        
        desired = (r*c+1)//2
        
        while minEle < maxEle:
            mid = minEle + (maxEle-minEle)//2
            
            count = 0
            for i in range(r):
                count += bisect_right(matrix[i], mid)
               
            if count < desired:
                minEle = mid+1
            else:
                maxEle = mid
        
        return minEle


if __name__ == '__main__': 
    ob = Solution()
    t = int (input ())

    while t > 0:
        r, c = [int(x) for x in input().split()]
        arr = [[0 for x in range(c)] for y in range(r)]
        elements = input().split()

        k = 0

        for i in range(r):
            for j in range(c):
                arr[i][j] = int(elements[k])
                k += 1

        print(ob.median(arr, r, c))
        t -= 1