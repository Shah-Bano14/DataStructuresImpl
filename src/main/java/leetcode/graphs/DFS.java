package leetcode.graphs;

import java.util.ArrayList;

public class DFS {  // generate DFS traversal

    public static void main(String[] args) {

        int adjm[][] = {{2,3},{1,5,6},{1,7,4},{8,3},{2},{2},{3,8},{4,7}};
        int[][] matrix = {   // defined adj matrix
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1, 0}
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int vis[] = new int[9];
        ArrayList<Integer> dfs = new ArrayList<>();
        int v = vis.length;
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

        generateDFS(1, vis, dfs, adj);

    }

    private static void generateDFS(int node, int[] vis, ArrayList<Integer> dfs, ArrayList<ArrayList<Integer>> adj) {

        System.out.print(node);
        vis[node]= 1;
        dfs.add(node);
        for(Integer i: adj.get(node))
        {
            if(vis[i]!=1)
            {
                generateDFS(i, vis, dfs, adj);
            }
        }
    }
}
