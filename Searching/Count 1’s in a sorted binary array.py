# Question Link (GFG): https://www.geeksforgeeks.org/count-1s-sorted-binary-array/

'''
Count 1’s in a sorted binary array

Given a binary array sorted in non-increasing order, count the number of 1’s in it. 
'''

def countOnes(arr, n):
    pos = -1
    start = 0
    end = n-1

    while start <= end:
        mid = start + (end-start)//2

        if arr[mid] == 1:
            pos = mid
            start = mid+1
        else:
            end = mid-1

    return pos+1 if pos != -1 else 0


t = int(input())
while t>0:
    n = int(input())
    arr = [int(x) for x in input().split()]
    print(countOnes(arr, n))
    t -= 1
