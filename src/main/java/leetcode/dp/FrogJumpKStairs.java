package leetcode.dp;

import java.util.Arrays;

/*
A frog wants to climb a staircase with n steps. Given an integer array heights, where heights[i] contains the height of the ith step, and an integer k.
To jump from the ith step to the jth step, the frog requires abs(heights[i] - heights[j]) energy, where abs() denotes the absolute difference. The frog can jump from the ith step to any step in the range [i + 1, i + k], provided it exists.
Return the minimum amount of energy required by the frog to go from the 0th step to the (n-1)th step.
Examples:
Input: heights = [10, 5, 20, 0, 15], k = 2

Output: 15

Explanation:

0th step -> 2nd step, cost = abs(10 - 20) = 10

2nd step -> 4th step, cost = abs(20 - 15) = 5

Total cost = 10 + 5 = 15.
 */
public class FrogJumpKStairs {

    public static void main(String[] args) {

        int heights[] = {10, 5, 20, 0, 15};
        int k = 2;

        int n = heights.length;

        System.out.println(" the recursion soln is:" + Recursion(n, heights, k));

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println("the memoisation soln is : " + MemoisationSoln(n, heights, k, dp));

        System.out.println("the tabulation soln is : "+ Tabulation(n-1, heights, k));
    }

    private static int Tabulation(int n, int[] heights, int k) {

        int dp[] = new int[n+1];
        dp[0] =0;

        for(int i=1;i<=n;i++)
        {
            int min  = Integer.MAX_VALUE;
            for(int j= 1;j<=k;j++)
            {
                int step = Integer.MAX_VALUE;
                if(i>=j)
                    step = Math.abs(heights[i]- heights[i-j])+dp[i-j];
                min = Math.min(min, step);
            }
            dp[i] = min;
        }

        return dp[n];
    }

    private static int MemoisationSoln(int n, int[] heights, int k, int[] dp) {

        if(n==0)
            return 0; // if on the same staircase, return 0;

        if(dp[n]!=-1)
            return dp[n];

        int min = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++)
        {

            if(n>=i){
             min = Math.min(Math.abs(heights[i] - heights[n-i]) + MemoisationSoln(n-i, heights, k, dp), min);
            }
        }

        return dp[n] = min;

    }

    private static int Recursion(int n, int[] heights, int k) {

        if(n==0)
            return 0;

        int min = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++)
        {
            if(n>=i){
                min = Math.min(Math.abs(heights[i] - heights[Math.abs(n-i)]) + Recursion(n-i, heights, k), min);
            }
        }

        return min;
    }
}
