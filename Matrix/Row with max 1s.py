# Question Link(GFG): https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1

'''
Row with max 1s

Given a boolean 2D array of n x m dimensions where each row is sorted. Find the 0-based index of the first row that has the maximum number of 1's.
'''

class Solution:
    def rowWithMax1s(self,arr, n, m):
        resultantRow = -1
        maxCount = count = 0
        
        for i in range(n):
            count = self.binarySearch(arr[i], 0, m-1)
            if count > maxCount:
                maxCount = count
                resultantRow = i
        
        return resultantRow
    
    def binarySearch(self, arr, start, end):
        pos = len(arr)
        
        while start <= end:
            mid = (start+end)//2
            
            if arr[mid] == 1:
                pos = mid
                end = mid-1
            else:
                start = mid+1
        
        return len(arr)-pos
        

if __name__ == '__main__':
    tc = int(input())
    while tc > 0:
        n, m = list(map(int, input().strip().split()))
        
        inputLine = list(map(int, input().strip().split()))
        arr = [[0 for j in range(m)] for i in range(n)]
        
        for i in range(n):
            for j in range(m):
                arr[i][j] = inputLine[i * m + j]
        ob = Solution()
        ans = ob.rowWithMax1s(arr, n, m)
        print(ans)
        tc -= 1

