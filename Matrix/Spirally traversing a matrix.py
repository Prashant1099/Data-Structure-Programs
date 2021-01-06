# Question Link(GFG): https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1

'''
Spirally traversing a matrix

Given a matrix of size R*C. Traverse the matrix in spiral form.
'''
def spiralMatrix(arr, m, n):
    rowStart = colStart = 0
    
    while rowStart < m and colStart < n:
        for i in range(colStart, n):
            print(arr[rowStart][i], end=" ")
        rowStart += 1
        
        for i in range(rowStart, m):
            print(arr[i][n-1], end=" ")
        n -= 1
        
        if rowStart<m:
            for i in range(n-1, colStart-1, -1):
                print(arr[m-1][i], end=" ")
            m -= 1
        
        if colStart<n:
            for i in range(m-1, rowStart-1, -1):
                print(arr[i][colStart], end=" ")
            colStart += 1




t = int(input())
while t>0:
    m, n = [int(x) for x in input().split()]
    arr = [[0 for x in range(n)] for y in range(m)]
    elements = input().split()
    
    k = 0
    for i in range(m):
        for j in range(n):
            arr[i][j] = int(elements[k])
            k += 1
            
    spiralMatrix(arr, m, n)
    print()
    t -= 1
    
    