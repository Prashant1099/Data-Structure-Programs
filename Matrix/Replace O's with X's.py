# Question Link(GFG): https://practice.geeksforgeeks.org/problems/replace-os-with-xs/0

'''
Replace O's with X's

Given a matrix of size NxM where every element is either ‘O’ or ‘X’, replace ‘O’ with ‘X’ if surrounded by ‘X’. A ‘O’ (or a set of ‘O’) is considered to be by surrounded by ‘X’ if there are ‘X’ at locations just below, just above, just left and just right of it.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. The first line of each test case contains two integers N and M denoting the size of the matrix. Then in the next line are N*M space separated values of the matrix.

Output:
For each test case print the space separated values of the new matrix.
'''


def floodFill(arr, x, y, toFill, prevFill):
    if (x < 0 or x >= m or y < 0 or y >= n):
        return 
    
    if arr[x][y] != prevFill:
        return
    
    arr[x][y] = toFill
    
    floodFill(arr, x-1, y, toFill, prevFill)
    floodFill(arr, x, y-1, toFill, prevFill)
    floodFill(arr, x+1, y, toFill, prevFill)
    floodFill(arr, x, y+1, toFill, prevFill)
    
    return arr


def replaceSurrounded(arr, m, n):
    for i in range (m):
        for j in range (n):
            if arr[i][j] == 'O':
                arr[i][j] = '-'
                
    for i in range (m):
        if arr[i][0] == '-':
            floodFill(arr, i, 0, 'O', '-')
    
    for i in range (m):
        if arr[i][n-1] == '-':
            floodFill(arr, i, n-1, 'O', '-')
    
    for i in range (n):
        if arr[0][i] == '-':
            floodFill(arr, 0, i, 'O', '-')
    
    for i in range (n):
        if arr[m-1][i] == '-':
            floodFill(arr, m-1, i, 'O', '-')
            
    for i in range (m):
        for j in range (n):
            if arr[i][j] == '-':
                arr[i][j] = 'X'
                
    return arr


t = int(input())
while (t > 0):
    m, n = map(int, input().split())
    arr = [[0 for _ in range (n)] for _ in range (m)]
    ele = input().split()
    
    for i in range (m):
        for j in range (n):
            arr[i][j] = ele[i*n+j]
            
    replaceSurrounded(arr, m, n)
    
    for ele in arr:
        print(*ele, end=" ")
    print()
    
    t -= 1