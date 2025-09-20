package leetcode.dp;

/*
A frog wants to climb a staircase with n steps. Given an integer array heights, where heights[i] contains the height of the ith step.
To jump from the ith step to the jth step, the frog requires abs(heights[i] - heights[j]) energy, where abs() denotes the absolute difference. The frog can jump from any step either one or two steps, provided it exists.
Return the minimum amount of energy required by the frog to go from the 0th step to the (n-1)th step.
Examples:
Input: heights = [2, 1, 3, 5, 4]

Output: 2

Explanation:

One possible route can be,

0th step -> 2nd Step = abs(2 - 3) = 1

2nd step -> 4th step = abs(3 - 4) = 1

Total = 1 + 1 = 2.

---------
Input: heights = [7, 5, 1, 2, 6]

Output: 9

Explanation:

One possible route can be,

0th step -> 1st Step = abs(7 - 5) = 2

1st step -> 3rd step = abs(5 - 2) = 3

3rd step -> 4th step = abs(2 - 6) = 4

Total = 2 + 3 + 4 = 9.
 */
public class FrogJump {

    public static void main(String[] args) {
        
        int heights[] = {7, 5, 1, 2, 6};
        int n = heights.length-1;

        int res = recursionSol(n, heights );
        System.out.println("the rec soln is :" + res);

        int dp[] = new int[n+1];
        System.out.println("the memo sol is :" + memoisationSol(n, heights, dp));

        System.out.println("the tabulation soln is: "+ tabulation(n, heights));
    }

    private static int recursionSol(int nthStair, int[] heights) {

        if(nthStair == 0) // if we are already in that staircase, we dont require any energy to reach that
            return 0;

        // i thot of putting conditions like nthstair == 1 then return heights of something, but we dont do that, since it will automatically
        // be calculated by the algorithm

        int oneStepEnergy = Math.abs(heights[nthStair] - heights[nthStair-1]) + recursionSol(nthStair-1, heights );
        int twoStepEnergy = Integer.MAX_VALUE;
        if(nthStair>1)
          twoStepEnergy = Math.abs(heights[nthStair] - heights[nthStair-2]) + recursionSol(nthStair-2, heights);

        return Math.min(oneStepEnergy, twoStepEnergy);

    }

    public static int memoisationSol(int n, int[] heights, int[] dp)
    {
        if(n==0)
            return 0; // no enerygy required to be on the same staircase

        if(dp[n]!=0)
            return dp[n];

        int oneStepEnergy = Math.abs(heights[n] - heights[n-1]) + recursionSol(n-1, heights );
        int twoStepEnergy = Integer.MAX_VALUE;
        if(n>1)
            twoStepEnergy = Math.abs(heights[n] - heights[n-2]) + recursionSol(n-2, heights);

        return dp[n] = Math.min(oneStepEnergy, twoStepEnergy);
    }

    public static int tabulation(int n, int[] heights)
    {
        int[] dp = new int[n+1];

        dp[0] = 0;
        for(int i=1;i<n+1;i++)
        {
            int one = Math.abs(heights[i]- heights[i-1]) + dp[i-1];
            int two = Integer.MAX_VALUE;
            if(i>1)
                two = Math.abs(heights[i] -heights[i-2]) + dp[i-2];

            dp[i] = Math.min(one, two);
        }

        return dp[n];
    }
}
