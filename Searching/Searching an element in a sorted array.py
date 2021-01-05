# Question Link (GFG): https://practice.geeksforgeeks.org/problems/who-will-win-1587115621/1

'''
Searching an element in a sorted array

Given a sorted array of size N and an integer K. Check if K is present in the array or not. If yes then return 1 else -1
'''

def searchInSortedArr(arr, n, k):
    start = 0
    end = n-1

    while(start <= end):
        mid = start + (end-start)//2

        if arr[mid] == k:
            return 1
        elif arr[mid] < k:
            start = mid+1
        else:
            end = mid-1
    
    return -1


t = int(input())
while t>0:
    n, k = [int(x) for x in input().split()]
    arr = [int(x) for x in input().split()]
    print(searchInSortedArr(arr, n, k))
    t -= 1