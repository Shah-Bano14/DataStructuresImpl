package leetcode.graphs;

//Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid)
//        consisting of '0's (Water) and '1's(Land). Find the number of islands.
//
//        Note: An island is either surrounded by water or boundary of grid and is formed
//        by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIsland {
    static int grid[][] = {{0,1,1,1,0,0,0},{0,0,1,1,0,1,0}};
    static int vis[][] = new int[grid.length][grid[0].length];
    public static void main(String[] args) {


        int count=0;
        int[] row = {-1, 0, 1, 0};
        int[] col = {0,1,0,-1};

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1 && vis[i][j]!=1)
                {
                    count++;
                    // generateBfs(i, j);         //--- method 1 uisng BFS
                    count(i,j, row, col, vis, grid);
                }
            }
        }

        System.out.println(count + ": is the count");
    }

    public static void count(int r, int c, int[] row, int[] col, int[][] vis, int[][] grid)
    {

        vis[r][c]=1;

        for(int i=-1;i<=1;i++)
        {
            for(int j=-1;j<=1;j++)   // check if asks for 6 sides or 4 sides check
            {
                int newRow = r+i;
                int newCol = c+j;

                if(newRow >=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length)
                {
                    if(grid[newRow][newCol]==1 && vis[newRow][newCol]==0)
                    {
                        count(newRow, newCol, row, col, vis, grid);
                    }
                }
            }

        }


    }

    private static void generateBfs(int r, int c) {

        vis[r][c]=1;
        Queue<Pair1> q= new LinkedList<>();
        q.add(new Pair1(r,c));

        while(!q.isEmpty())
        {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            for(int i=-1;i<=1;i++)
            {
                for(int j=-1;j<=1;j++)
                {
                    int nr = row+i;
                    int nc = col+j;
                    if(nr >=0 && nr <grid.length && nc>=0 && nc<grid[0].length
                            && vis[nr][nc]!=1 && grid[nr][nc] == 1)
                    {

                            vis[nr][nc]=1;
                            q.add(new Pair1(nr,nc));


                    }
                }
            }
        }

    }
}

class Pair1 {
    int first;
    int second;
    public Pair1(int first, int second){
        this.first=first;
        this.second=second;
    }
}
