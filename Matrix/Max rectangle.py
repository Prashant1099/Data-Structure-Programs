# Question Link(GFG): https://practice.geeksforgeeks.org/problems/max-rectangle/1

'''
Max rectangle

Given a binary matrix. Find the maximum area of a rectangle formed only of 1s in the given matrix.
'''


def maxRectangle(M, n, m):
    tempArr = [0]*m
    maxArea = 0
    
    for row in M:
        for i in range(m):
            tempArr[i] = tempArr[i]+row[i] if row[i] != 0 else 0
        
        area = ractangularArea(tempArr, m)
        
        maxArea = max(area, maxArea)
    
    return maxArea

def ractangularArea(histogram, n):
    maxArea = i = 0
    stack = list()
    
    while i<n:
        if not stack or histogram[stack[-1]] <= histogram[i]:
            stack.append(i)
            i += 1
        else:
            poppedIndex = stack.pop()
            
            area = histogram[poppedIndex] * ((i-stack[-1]-1) if stack else i)
            
            maxArea = max(area, maxArea)
    
    while stack:
        poppedIndex = stack.pop()
        
        area = histogram[poppedIndex] * ((i-stack[-1]-1) if stack else i)
        
        maxArea = max(area, maxArea)
    
    return maxArea


if __name__ == '__main__':
    t=int(input())
    for _ in range(t):
        R, C = input().split()
        a=list(map(int,input().split()))
        j=0
        A=[]
        R=int(R)
        C=int(C)
        for i in range(0,R):
            A.append(a[j:j+C])
            j=j+C
        
        print(maxRectangle(A, R, C)) 