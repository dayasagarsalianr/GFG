import java.util.Arrays;

class Solution {
    public int largestArea(int n, int m, int[][] mat) {
        int k = mat.length;
        
        // Arrays to store blocked rows and columns
        int[] rows = new int[k + 2];
        int[] cols = new int[k + 2];
        
        // Add boundaries (0 and n+1 / m+1)
        rows[0] = 0;
        rows[1] = n + 1;
        cols[0] = 0;
        cols[1] = m + 1;
        
        // Fill the rest with the given coordinates
        for (int i = 0; i < k; i++) {
            rows[i + 2] = mat[i][0];
            cols[i + 2] = mat[i][1];
        }
        
        // Sort to find the consecutive gaps
        Arrays.sort(rows);
        Arrays.sort(cols);
        
        // Find maximum row gap
        int maxRowGap = 0;
        for (int i = 1; i < rows.length; i++) {
            maxRowGap = Math.max(maxRowGap, rows[i] - rows[i - 1] - 1);
        }
        
        // Find maximum column gap
        int maxColGap = 0;
        for (int i = 1; i < cols.length; i++) {
            maxColGap = Math.max(maxColGap, cols[i] - cols[i - 1] - 1);
        }
        
        // Return the area of the largest unblocked submatrix
        return maxRowGap * maxColGap;
    }
}