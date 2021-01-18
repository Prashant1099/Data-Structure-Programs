# Question Link (Leetcode): https://leetcode.com/problems/search-a-2d-matrix/

'''
Search in a 2D Matrix

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.
'''


class Solution:
    def searchMatrix(self, matrix, target):
        rowLen = len(matrix)
        if rowLen < 1:
            return False
        
        colLen = len(matrix[0])
        if colLen < 1:
            return False
        
        for row in matrix:
            if target > row[-1]:
                continue
            else:
                result = self.binarySearch(row, 0, colLen-1, target)
            
            return result
    
    def binarySearch(self, arr, start, end, target):
        while start <= end:
            mid = (start+end)//2
            
            if arr[mid] == target:
                return True
            elif arr[mid] < target:
                start = mid+1
            else:
                end = mid-1
        
        return False

