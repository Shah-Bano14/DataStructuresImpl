package leetcode.dp;

public class ClimbingStairs {

    public static int climbStairsRescursion(int n) {

        if(n==1)
            return 1;
        if(n==2)
            return 2;

        return climbStairsRescursion(n-1)+ climbStairsRescursion(n-2);

    }

    public static int memoisation(int n, int[] dp)
    {
        if(n==1)
            return 1;
        if(n==2)
            return 2;

        if(dp[n]!=0)
            return dp[n];

        return dp[n] = memoisation(n-1, dp)+ memoisation(n-2, dp);
        // here I was thinking why I am adding both the ways, like why the third staircase is sum of second and first count, but then I realised
        // its a way we think this solution: its the number of ways we can go to stair one plus number of ways to go to stair two:
        // ot like finding all possible ways = sum of all ways : try to understand this in the form of recursion tree

        // it first goes into the tree structure if f(n-1)( taking one step) and get all ways for that
        // then it goes into the tree structure of f(n-2)(taking 2 steps) and get all ways
        // get goood with the base cases
        // just add both ways to find all ways.
    }

    public static void main(String[] args) {

        int n = 5;

        int res = climbStairsRescursion(n);
        System.out.println(" the recursion ways are :" + res);

        int dp[] = new int [n+1];
        int res1 = memoisation(n, dp);
        System.out.println(" the meoisation ways are :" + res1);

        int dp1[] = new int [n+1];
        int res2 = tabulation(n, dp1);
        System.out.println("the tabulation ways are:" + res2);


    }

    private static int tabulation(int n, int[] dp1) {

        dp1[1] = 1;
        dp1[2] = 2;
        for(int i=3;i<n+1;i++)
        {
            dp1[i] = dp1[i-1] + dp1[i-2];
        }

        return dp1[n];
    }
}
