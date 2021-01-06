# Question Link(GFG): https://practice.geeksforgeeks.org/problems/find-the-string-in-grid/0

'''
Find the string in grid

Given a 2D grid (G[]) of characters and a word(x), find all occurrences of given word in grid. A word can be matched in all 8 directions at any point. Word is said be found in a direction if all characters match in this direction (not in zig-zag form).

The 8 directions are, Horizontally Left, Horizontally Right, Vertically Up, Vertically down and 4 Diagonal directions.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow.  Each test case contains two space separated integers N and M denoting the size of the grid. Then in the next line are N * M space separated values of the grid. In the next line is the word x.

Output:
For each test case in a new line print the space separated sorted indexes of the matrix where after each index there is a ', ' . If there are no such occurences print -1.
'''


class Solution:
    def __init__(self):
        self.direction = [[-1,-1], [-1,0], [-1, 1],
                                [0,-1], [0,1],
                            [1,-1], [1,0], [1,1]]
    
    def findStringInGrid(self, grid, n, m, word):
        flag = False
        for i in range(n):
            for j in range(m):
                if self.searchString(grid, i, j, n, m, word):
                    flag = True
                    print(i, j, end=", ")
        
        if flag == False:
            print(-1, end=" ")
                    
    def searchString(self, grid, i, j, row, col, word):
        if grid[i][j] != word[0]:
            return False
        
        for x, y in self.direction:
            rowDir = x+i
            colDir = y+j
            flag = True
            
            for k in range(1, len(word)):
                if(0 <= rowDir < row) and (0 <= colDir < col) and (grid[rowDir][colDir] == word[k]):
                    rowDir += x
                    colDir += y
                else:
                    flag = False
                    break
            
            if flag:
                return True
    
        return False
    
t = int(input())
while t>0:
    obj = Solution()
    n,m = [int(x) for x in input().split(" ")]
    grid = [[0 for i in range(m)] for j in range(n)]
    ele = input().split()
    word = input()
    
    k = 0
    for i in range(n):
        for j in range(m):
            grid[i][j] = ele[k]
            k += 1
    
    obj.findStringInGrid(grid, n, m, word)
    print()
    t -= 1
    