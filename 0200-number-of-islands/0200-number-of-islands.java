class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for(int r=0; r<row; r++){
            for(int c=0; c <col; c++){
                if(grid[r][c] == '1'){
                    solve(grid, row, col, r, c);
                    count++;
                }
            }
        }
        return count;
    }
    public void solve(char[][] arr, int row, int col, int r, int c){
        if(r == row || c == col || r < 0 || c < 0 || arr[r][c] == '0'){
            return;
        }
        arr[r][c] = '0';
        solve(arr, row, col, r-1, c);
        solve(arr, row, col, r+1, c);
        solve(arr, row, col, r, c-1);
        solve(arr, row, col, r, c+1);
    }
}