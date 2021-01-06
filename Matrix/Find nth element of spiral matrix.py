# Question Link(GFG):

'''
Find nth element of spiral matrix

Given a matrix with n rows and m columns. Your task is to find the kth element which is obtained while traversing the matrix spirally. You need to complete the method findK which takes four arguments the first argument is the matrix A and the next two arguments will be n and m denoting the size of the matrix A and then the forth argument is an integer  k denoting the kth element . The function will return the kth element obtained while traversing the matrix spirally.
'''


def findK(arr, m, n, q):
    k, l, count = 0, 0, 0
    
    while k < m and l < n:
        for i in range(l, n):
            count += 1
            
            if count == q:
                return arr[k][i]
        k += 1
        
        for i in range(k, m):
            count += 1
            
            if count == q:
                return arr[i][n-1]
        n -= 1
        
        if k < m:
            for i in range(n-1, l-1, -1):
                count += 1
                
                if count == q:
                    return arr[m-1][i]
            m -= 1
        
        if l < n:
            for i in range(m-1, k-1, -1):
                count += 1
                
                if count == q:
                    return arr[i][l]
            l += 1


if __name__=='__main__':
    t = int(input())
    for i in range(t):
        n = list(map(int, input().strip().split()))
        arr = list(map(int, input().strip().split()))
        matrix = [[0 for i in range(n[1])]for j in range(n[0])]
        c=0
        for i in range(n[0]):
            for j in range(n[1]):
                matrix[i][j] = arr[c]
                c+=1
        print(findK(matrix, n[0], n[1], n[2]))
