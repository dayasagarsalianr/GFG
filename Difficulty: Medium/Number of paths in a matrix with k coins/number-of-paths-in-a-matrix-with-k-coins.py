class Solution:
    def numberOfPath(self, mat, k):
        n, m = len(mat), len(mat[0])
        dp = [[0] * (k + 1) for _ in range(m)]
        if mat[0][0] <= k:
            dp[0][mat[0][0]] = 1
        for j in range(1, m):
            for s in range(mat[0][j], k + 1):
                dp[j][s] = dp[j - 1][s - mat[0][j]]
        for i in range(1, n):
            ndp = [[0] * (k + 1) for _ in range(m)]
            if mat[i][0] <= k:
                for s in range(mat[i][0], k + 1):
                    ndp[0][s] = dp[0][s - mat[i][0]]
            for j in range(1, m):
                for s in range(mat[i][j], k + 1):
                    ndp[j][s] = ndp[j - 1][s - mat[i][j]] + dp[j][s - mat[i][j]]
            dp = ndp
        return dp[m - 1][k]