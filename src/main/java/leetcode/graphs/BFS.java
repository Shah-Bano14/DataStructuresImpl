package leetcode.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static ArrayList<Integer> bfs = new ArrayList<>();

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

        Queue<Integer> queue = new LinkedList<>();
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
        queue.add(1);
        vis[1]=1;
        generateBFS(vis, queue,adj);
        for(int i=0;i<v-1;i++)
        {
            System.out.print(bfs.get(i));
        }

    }

    private static void generateBFS(int[] vis, Queue<Integer> queue, ArrayList<ArrayList<Integer>> adj) {

        while(!queue.isEmpty()) {
            int n = queue.poll();
            bfs.add(n);

            for (Integer i : adj.get(n)) {
                if (vis[i] != 1) {
                    vis[i] = 1;
                    queue.add(i);
                }
            }
//            generateBFS(vis, queue, adj);
            }
        }
    }

