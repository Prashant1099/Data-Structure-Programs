# Question Link(GFG): https://practice.geeksforgeeks.org/problems/solve-the-sudoku-1587115621/1

'''
Is Sudoku Valid

Given an incomplete Sudoku configuration in terms of a 9x9  2-D square matrix (mat[][]) the task to check if the configuration has a solution or not. 

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains 9*9 space separated values of the matrix mat[][] representing an incomplete Sudoku state where a 0 represents empty block.

Output:
For each test case in a new line print 1 if the sudoku configuration is valid else print 0.
'''

def occuredInRow(arr, row, num):
    count = 0
    
    for i in range(9):
        if arr[row][i] == num:
            count += 1
        
        if count > 1:
            return True
    
    return False

def occuredInCol(arr, col, num):
    count = 0
    
    for i in range(9):
        if arr[i][col] == num:
            count += 1
            
        if count > 1:
            return True
    
    return False

def checkValidity(arr):
    for i in range(9):
        for j in range(9):
            if arr[i][j] != 0:
                num = arr[i][j]
                if occuredInRow(arr, i, num) or occuredInCol(arr, j, num):
                    return 0
        
        return 1


t = int(input())
while t > 0:
    ele = input().split()
    arr = [[0]*9 for _ in range(9)]
    
    k = 0
    for row in arr:
        for i in range(9):
            row[i] = int(ele[k])
            k += 1

    print(checkValidity(arr))

    t -= 1