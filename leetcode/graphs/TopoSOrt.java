package leetcode.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopoSOrt {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();

        for(int i=0;i<6;i++){
            ArrayList<Integer> list = new ArrayList<>();
            input.add(list);
        }

        input.get(1).add(3);
        input.get(2).add(3);
        input.get(4).add(0);
        input.get(4).add(1);
        input.get(5).add(0);
        input.get(5).add(2);

//        int[] res = topoSort(6, input); // method 1.

        //method 2 : using BFS -- Kahn's algorithm

        int[] res = topoSortUsingBFS(6, input);

        for(int i=0;i<res.length;i++)
        {
            System.out.println(res[i] + " ");
        }




    }

    private static int[] topoSortUsingBFS(int V, ArrayList<ArrayList<Integer>> input) {

        int[] indeg = new int[V];

        for(int i=0;i<V;i++)
        {
            for(int j=0;j<input.get(i).size();j++)
            {
                int val = input.get(i).get(j);
                indeg[val]++;
            }
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<V;i++)
        {
            if(indeg[i]==0)
                queue.add(i);
        }

        ArrayList<Integer> res = new ArrayList<>();

        while(!queue.isEmpty())
        {
            int val = queue.poll();
            res.add(val);

            for(int i=0;i<input.get(val).size();i++)
            {
                int x = input.get(val).get(i);
                indeg[x]--;
                if(indeg[x]==0)
                    queue.add(x);
            }

        }

        int[] result = new int[V];
        for(int i=0;i<V;i++)
        {
            result[i] = res.get(i);
        }

        return result;
    }

    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here



        ArrayList<ArrayList<Integer>> li = new ArrayList<>();

        int vis[] = new int[V];
        int[] result = new int[V];

        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0;i<V;i++)
        {
            ArrayList<Integer> al = new ArrayList<>();
            li.add(al);
        }

        createAdjNew(V, adj, li);
//        for(int i=0;i<V;i++)
//        {
//            System.out.println("for i " + i);
//            for(int j=0;j<li.get(i).size();j++)
//            {
//                System.out.println(li.get(i).get(j));
//            }
//        }

        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                traverse(i, li, vis, res);
            }
        }


        for(int i=0;i<V;i++)
        {
            result[i] = res.get(i);
        }

        return result;
    }

    public static void traverse(int ind, ArrayList<ArrayList<Integer>> li, int[] vis, ArrayList<Integer> res)
    {
        vis[ind]=1;

        for(int i=0;i<li.get(ind).size();i++)
        {
            int val = li.get(ind).get(i);
            if(vis[val]!=1)
            {
                traverse(val, li, vis, res);
            }

        }

        res.add(ind);


    }

    public static void createAdjNew(int v, ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> li )
    {

        for(int i=0;i<v;i++)
        {
            for(int j=0;j<adj.get(i).size();j++)
            {
                int val = adj.get(i).get(j);
                li.get(val).add(i);
            }
        }


    }
}
