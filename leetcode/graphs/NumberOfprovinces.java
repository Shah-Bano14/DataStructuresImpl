package leetcode.graphs;

import java.util.ArrayList;

//space complexity: vis array O(N) + recursion stack space O(N) worst case
//time compl: O(N) outer forloop + O(V+2E) dfs calls and its degree calls aprox: O(N)
public class NumberOfprovinces {

    public static void main(String[] args) {

        //https://practice.geeksforgeeks.org/problems/number-of-provinces/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number_of_provinces
        int adjm[][] = {{2,3},{1,5,6},{1,7,4},{8,3},{2},{2},{3,8},{4,7}};
        int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 0}
        };

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int vis[] = new int[9];
        int v = vis.length;

        // genrate adjacency matrix
        for(int i=0;i<v;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=1;i<v;i++)
        {
            for(int j=1;j<v;j++)
            {
                if(matrix[i][j]==1 && i!=j)
                {
                    adj.get(i).add(j);
                }
            }
        }

        int count=0;
        for(int i=1;i<v;i++)
        {
            if(vis[i]==0)
            {
                count++;
                dfs(i,vis,adj);

            }
        }

        System.out.println("the number of provinces = " + count);

    }

    private static void dfs(int i, int[] vis, ArrayList<ArrayList<Integer>> adj) {

        vis[i]=1;
        for(Integer j:adj.get(i))
        {
            if(vis[j]!=1)
            {
                dfs(j, vis, adj);
            }
        }
    }
}
