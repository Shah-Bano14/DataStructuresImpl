package leetcode.recusion;

import javax.swing.*;

public class CalculateMinPathInGrid {

    public static int minPathSum(int[][] grid) {

        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j] = -1;
            }
        }

        int minPath = calculateMinPath(0,0, dp, grid);
        return minPath;
    }

    public static int calculateMinPath(int r, int c, int[][] dp, int[][] grid)
    {
        if(r== grid.length-1 && c == grid[0].length-1 )
            return grid[r][c];
        if(r> grid.length -1 || c> grid[0].length -1 )
            return (int) Math.pow(10, 9);

        if(dp[r][c] >0)
            return dp[r][c];

        int left = grid[r][c] + calculateMinPath(r, c+1, dp, grid);

        int right =grid[r][c] + calculateMinPath(r+1, c,dp, grid);

        return dp[r][c] = Math.min(left, right);
    }

    public static void main(String args[])
    {

        int[][] grid = {{1,2,3},{4,5,6}};
        //int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int value = minPathSum(grid);
        System.out.println(value + " this is the value");


    }
}
