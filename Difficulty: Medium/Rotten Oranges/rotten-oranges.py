class Solution:
    def orangesRot(self, mat):
        from collections import deque
        n, m = len(mat), len(mat[0])
        q, fresh = deque(), 0
        for i in range(n):
            for j in range(m):
                if mat[i][j] == 2: q.append((i, j))
                elif mat[i][j] == 1: fresh += 1
        time, dirs = 0, [(0,1),(0,-1),(1,0),(-1,0)]
        while q and fresh:
            time += 1
            for _ in range(len(q)):
                x, y = q.popleft()
                for dx, dy in dirs:
                    nx, ny = x+dx, y+dy
                    if 0<=nx<n and 0<=ny<m and mat[nx][ny]==1:
                        mat[nx][ny] = 2; fresh -= 1; q.append((nx, ny))
        return -1 if fresh else time