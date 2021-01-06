# Question Link(GFG): https://practice.geeksforgeeks.org/problems/unique-rows-in-boolean-matrix/1

'''
Unique rows in boolean matrix

Given a binary matrix your task is to find all unique rows of the given matrix.
'''


def printmat(row, col, matrix):
    arr = [[0]*col for _ in range(row)]
    k = 0
    for rows in arr:
        for cols in range(col):
            rows[cols] = int(matrix[k])
            k += 1
    
    matrix = []
    
    for rows in arr:
        if rows not in matrix:
            matrix.append(rows)
    
    for rows in matrix:
        print(*rows, end=' $')
    print()


def main():
    testcase = int(input())
    while(testcase):
        s = input().split()
        row = int(s[0])
        col = int(s[1])
        matrix = input().split()
        
        printmat(row, col, matrix)
        
        testcase -= 1

if __name__ == "__main__":
    main()