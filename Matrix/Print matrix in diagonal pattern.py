# Question Link(GFG): https://practice.geeksforgeeks.org/problems/print-matrix-in-diagonal-pattern/1

'''
Print matrix in diagonal pattern

Given a matrix M of n*n size, the task is to complete the function which prints its elements in diagonal pattern as depicted below.
'''


def matrixDiagonally(arr, n):
    row = col = i = 0
    up = True
    temp = list()
    
    while i < n*n:
        if up:
            while row >= 0 and col < n:
                temp.append(arr[row][col])
                row -= 1
                col += 1
                i += 1
            
            if row < 0 and col <= n-1:
                row = 0
            if col == n:
                row += 2
                col -= 1
        else:
            while col >= 0 and row < n:
                temp.append(arr[row][col])
                col -= 1
                row += 1
                i += 1
            
            if col < 0 and row <= n-1:
                col = 0
            if row == n:
                col += 2
                row -= 1
        
        up = not up
    
    return temp
        

if __name__=='__main__':
    t = int(input())
    for i in range(t):
        n = list(map(int, input().strip().split()))
        arr = list(map(int, input().strip().split()))
        matrix = [[0 for i in range(n[0])]for j in range(n[0])]
        k=0
        for i in range(n[0]):
            for j in range(n[0]):
                matrix[i][j] = arr[k]
                k+=1
        a = matrixDiagonally(matrix, n[0])
        for x in a:
            print(x,end=' ')
        print('')