package leetcode.dp;


import java.util.Arrays;

/*
A ninja has planned a n-day training schedule. Each day he has to perform one of three activities - running, stealth training, or fighting practice. The same activity cannot be done on two consecutive days and the ninja earns a specific number of merit points, based on the activity and the given day.
Given a n x 3-sized matrix, where matrix{i]{0], matrix{i]{1], and matrix{i]{2], represent the merit points associated with running, stealth and fighting practice, on the (i+1)th day respectively. Return the maximum possible merit points that the ninja can earn.
 Input: matrix = {{10, 40, 70], {20, 50, 80], {30, 60, 90]]
Output: 210
Explanation:
Day 1: fighting practice = 70
Day 2: stealth training = 50
Day 3: fighting practice = 90
Total = 70 + 50 + 90 = 210
This gives the optimal points.
 */
public class NinjaTraining {

    public static void main(String[] args) {

        int mat[][] = {{10, 40, 70}, {20, 50, 80}, {30, 60, 90}};


        int res = rec(0, mat, -1);
        System.out.println("the recursion result is : "+ res );

        int dp[][] = new int[mat.length][4];
        for(int i=0;i< mat.length;i++)
        {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("the memo soln is :" + memo(0, mat, 3, dp));

        int tabRes = tabulation(0, 4, mat);
        System.out.println("the tabulation solution is : "+ tabRes);

    }

    private static int tabulation(int n, int task, int[][] mat) {

        //base condition : the values when dp[0][n] == values when ninja has one day only, what are the max values he gets for a last task t
        // eg.last task is 1, then max will be max(1, 2)
        int dp[][] = new int[mat.length][task];
        dp[0][0] = Math.max(mat[0][1], mat[0][2]);
        dp[0][1] = Math.max(mat[0][0], mat[0][2]);
        dp[0][2] = Math.max(mat[0][0], mat[0][1]);
        dp[0][3] = Math.max(mat[0][0], Math.max( mat[0][2], mat[0][1]));

        //note to convert to tabulation, you hav eto create as many loops as of the changing index values in the memo solution
        // eg, in this question, there are two changing values - day and lastTask, so we create a two loops for both
        // and then we copy the same code as memo just changeing the recursive calls to dp values
        // also note: the dp array maytrix dimension is also equal to changing varibales count, heres a 2D array
        // since 2 chanding variables....
        for(int i=1;i< mat.length;i++)
        {
            for(int taskLast=0;taskLast<task;taskLast++)
            {
                int max = Integer.MIN_VALUE;
                for(int k=0;k<mat[0].length;k++)
                {
                    if(k!=taskLast)
                        max = Math.max(max, mat[i][k] + dp[i-1][k]);
                }

                dp[i][taskLast] = max;
            }
        }

        return dp[mat.length-1][dp[0].length-1];
    }

    private static int memo(int n, int[][] mat, int task, int[][] dp) {

        if(n== mat.length)
            return 0;

        if(dp[n][task]!=-1) return dp[n][task];

        int max = Integer.MIN_VALUE;
        for(int i=0;i<mat[0].length;i++)
        {
            if(i!=task)
                max = Math.max(max, mat[n][i]+memo(n+1, mat, i, dp));
        }

        return dp[n][task] = max;
    }


    // hre try and understand what this function mean
    // fun(n, task) if from (n-1->0) means what is the max merit the ninja has earned
    //if he perfornmmed the task from 0 to nth index with the last task as task.
    // in reverse, when you go from 0-> n-1 ( passing 0 in function first) ---> it means
    // whgats the max merit ninja has earned when he performed tasks from n-1 to nth day with last task being = task
    private static int rec(int n, int[][] mat, int task) {

        if(n==mat.length)
            return 0;

        int max = Integer.MIN_VALUE;
        for(int i=0;i<mat[0].length;i++)
        {
            if(task!=i)
                max = Math.max(max, mat[n][i] + rec(n+1, mat, i));

        }

        return max;
    }
}
