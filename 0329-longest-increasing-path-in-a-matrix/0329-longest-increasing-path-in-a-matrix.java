class Solution {
    public int longestIncreasingPath(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int max = 0;
        int[][] dp = new int[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                int ans = solve(arr, row, col, r, c, 0, -1, dp);
                max = Math.max(max, ans);
            }
        }
        return max;

    }

    public int solve(int[][] arr, int row, int col, int r, int c, int count, int prev, int[][] dp) {
        if (row == r || r < 0 || col == c || c < 0 || arr[r][c] <= prev)
            return 0;
        if(dp[r][c] != 0) return dp[r][c];
        int add = 1;
        int mark = arr[r][c];
        int ans1 = add + solve(arr, row, col, r - 1, c, count + 1, mark, dp);
        int ans2 = add + solve(arr, row, col, r + 1, c, count + 1, mark, dp);
        int ans3 = add + solve(arr, row, col, r, c - 1, count + 1, mark, dp);
        int ans4 = add + solve(arr, row, col, r, c + 1, count + 1, mark, dp);
        return dp[r][c] = Math.max(Math.max(ans1, ans2),Math.max(ans3, ans4));
    }
}