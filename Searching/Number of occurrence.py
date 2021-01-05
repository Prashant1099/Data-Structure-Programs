# Question Link (GFG): https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1#

'''
Number of occurrence

Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.
'''


class Solution:
	def count(self,arr, n, x):
		start = 0
		end = n-1
		
		first = self.firstOccurrence(arr, start, end, x)
		
		if first == -1:
		    return 0
		
		last = self.lastOccurrence(arr, start, end, x)

		return last-first+1
	
	def firstOccurrence(self, arr, start, end, x):
	    pos = -1
    
        while start <= end:
            mid = start + (end-start)//2
            
            if arr[mid] == x:
                pos = mid
                end = mid-1
            elif arr[mid] < x:
                start = mid+1
            else:
                end = mid-1
            
        return pos
    
    def lastOccurrence(self, arr, start, end, x):
        while start <= end:
            mid = start + (end-start)//2
            
            if arr[mid] == x:
                pos = mid
                start = mid+1
            elif arr[mid] < x:
                start = mid+1
            else:
                end = mid-1
        
        return pos


if __name__ == '__main__':
    tc = int(input())
    while tc > 0:
        n, x = list(map(int, input().strip().split()))
        arr = list(map(int, input().strip().split()))
        ob = Solution()
        ans = ob.count(arr, n, x)
        print(ans)
        tc -= 1
