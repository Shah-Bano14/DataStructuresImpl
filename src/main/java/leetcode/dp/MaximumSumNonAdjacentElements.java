package leetcode.dp;

import java.util.Arrays;

/*
Given an integer array nums of size n. Return the maximum sum possible using the elements of nums such that no two elements taken are adjacent in nums.
Input: nums = [1, 2, 4]
Output: 5
Explanation:
[1, 2, 4], the underlined elements are taken to get the maximum sum.
 */

/*
Recursion is Beautyyyyyyy--------------- Trust me
approach is: find all subsequences with the given constraint and find the one with max sum. we have the find the max sum possible so no ele is adjacent, for that, lets say we take
first ele, then we cannnot take second and have to go with third, if we do not take the first ele, thern
we can take the second and find the max of the two recuirsive calls.
--------- This is a Take/Not take problem


// note in the tabulastion to handle the negative index base case, I extended the dp length from 0 ->n to 0 to n+1 where 0th index handles the negative
value.......... This is prime way of handling negative base cases. I am considering the value from 1th to nthn index. to handle it... hurrahhhhhh
TC: O(N) for memo and tab , 0 2^n for rec
SC: ON - tab, ON fpr recur, O(n+N) for memo
 */
public class MaximumSumNonAdjacentElements {

    public static void main(String[] args) {

        int nums[] = {2, 1, 4, 9};

        int n = nums.length;

        System.out.println("the recurive soln is :"+ rec(n-1 , nums));

        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        System.out.println("the memoisation soln is :"+ memo(n-1, nums, dp));

        System.out.println("the tabulation soln is : " + tab(n, nums));
    }

    private static int tab(int n, int[] nums) {

        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1]= nums[0];

        for(int i=2;i<n+1;i++)
        {
            int dontTake = dp[i-1];
            int take = nums[i-1] + dp[i-2];

            dp[i] = Math.max(dontTake, take);

        }
        return dp[n];
    }

    private static int memo(int n, int[] nums, int[] dp) {

        if(n<0)
            return 0;

        if(dp[n]!= -1)
            return dp[n];

        int dontTake = memo(n-1, nums, dp);

        int take = nums[n] + memo(n-2, nums, dp);

        return dp[n] = Math.max(dontTake, take);

    }

    static int rec(int n, int[] nums) {

        if(n<0)
            return 0;

        int dontTake = rec(n-1, nums);

        int take = nums[n] + rec(n-2, nums);

        return Math.max(dontTake, take);
    }
}
