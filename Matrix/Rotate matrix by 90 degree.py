# Question Link(GFG): https://practice.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1

'''
Rotate Matrix by 90 degree

Given a square matrix[][] of size N x N. The task is to rotate it by 90 degrees in an anti-clockwise direction without using any extra space.
'''

def rotate(arr): 
    for i in range(N//2):
        k = N-i-1
        for j in range(i, k):
            temp = arr[i][j]
            
            arr[i][j] = arr[j][k]
            arr[j][k] = arr[k][N-j-1]
            arr[k][N-j-1] = arr[N-j-1][i]
            arr[N-j-1][i] = temp
    
    return arr


if __name__ == '__main__':
	t = int(input())
	for _ in range(t):
		N=int(input())
		arr=[int(x) for x in input().split()]
		matrix=[]

		for i in range(0,N*N,N):
			matrix.append(arr[i:i+N])

		rotate(matrix)
		for i in range(N): 
			for j in range(N): 
				print(matrix[i][j], end =' ') 
			print() 
