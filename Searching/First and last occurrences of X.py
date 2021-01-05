# Question Link (GFG): https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x/0

'''
First and last occurrences of X

Given a sorted array with possibly duplicate elements, the task is to find indexes of first and last occurrences of an element x in the given array.

Note: If the number x is not found in the array just print '-1'.

Input:
The first line consists of an integer T i.e number of test cases. The first line of each test case contains two integers n and x. The second line contains n spaced integers.

Output:
Print index of the first and last occurrences of the number x with a space in between.
'''

def searchInSortedArr(arr, n, x):
    start, end = 0, n-1
    
    firstOccurence = findFirstOccurence(arr, start, end, x)
    
    if firstOccurence == -1:
        return print(-1)
        
    lastOccurence = findLastOccurence(arr, start, end, x)
    
    print(firstOccurence, lastOccurence)
    
def findFirstOccurence(arr, start, end, x):
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

def findLastOccurence(arr, start, end, x):
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


t = int(input())
while t>0:
    n, x = [int(x) for x in input().split()]
    arr = [int(x) for x in input().split()]
    searchInSortedArr(arr, n, x)
    t -= 1