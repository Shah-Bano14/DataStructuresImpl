package leetcode.graphs;

/*
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image.

        Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill,
        and a pixel value newColor, "flood fill" the image.

        To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally
        to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally
         to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of
          the aforementioned pixels with the newColor.
*/
import java.util.LinkedList;
import java.util.Queue;

class FloodFill
{

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,1,0},{1,0,1}};


        int sr = 1, sc = 1;
        int newColor = 2;
        int result[][] = floodFill(matrix, sr, sc, newColor);
        for(int i=0;i<result.length;i++)
        {
            for(int j=0;j<result[0].length;j++)
            {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here
        int vis[][] = new int [image.length][image[0].length];
        Queue<Pair> q = new LinkedList<Pair>();

        int result[][] = bfs(sr, sc, image, newColor, vis, q);
        return result;
    }

    public static int[][] bfs(int sr, int sc, int image[][], int nColor,  int vis[][], Queue<Pair> q)
    {
        vis[sr][sc] = 1;
        int sp = image[sr][sc];
        image[sr][sc] = nColor;
        q.add(new Pair(sr,sc));

        while(!q.isEmpty())
        {
            int r = q.peek().row;
            int c = q.peek().col;
            q.remove();

            for(int i=-1;i<=1;i++)
            {
                for(int j=-1;j<=1;j++)
                {
                    int nr = r+i;
                    int nc = c+j;
                    if(nr >=0 && nr <image.length && nc>=0 && nc<image[0].length
                            && vis[nr][nc]!=1 && image[nr][nc] == sp)
                    {
                        if((i==-1 && j==0) || (i==0 && j==-1) || (i==1 && j==0) || (i==0 && j==1)){
                            vis[nr][nc]=1;
                            image[nr][nc]=nColor;
                            q.add(new Pair(nr,nc));
                        }

                    }
                }
            }
        }

        return image;

    }
}

class Pair{
    int row;
    int col;
    public Pair(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
}
