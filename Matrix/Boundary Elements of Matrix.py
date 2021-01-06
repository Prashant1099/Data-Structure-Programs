# # Question Link(GFG): https://practice.geeksforgeeks.org/problems/boundary-elements-of-matrix/0

'''
Boundary Elements of Matrix

Given an NxN matrix .In the given matrix, you have to print the boundary elements of the matrix.

Input:
First line consists of  the input contains an intger T denoting the number of  test cases. Then T test cases follow. First line of every test case consists of an integer N, denoting size of the Matrix. Second line of every test case consists of N x N spaced integers denoting elements of Matrix elements.

Output:
For each test case output a single line output, print the boundary elements of the matrix.
'''

def boundryElement(arr, n):
    print(*arr[0], end=" ")
    
    for i in range(1, n-1):
        print(arr[i][0], arr[i][n-1], end=" ")
    
    if n > 1:
        print(*arr[-1], end=" ")
    
t = int(input())
while t > 0:
    n = int(input())
    arr = [[0]*n for _ in range(n)]
    ele = input().split()
    k = 0
    for i in range(n):
        for j in range(n):
            arr[i][j] = int(ele[k])
            k += 1
    boundryElement(arr, n)
    print()
    t -= 1
    