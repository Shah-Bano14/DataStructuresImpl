package leetcode.dp;

import java.util.Arrays;

public class CoinsChange {

    public static int coinChange(int[] coins, int amount) {

        if(amount == 0)
            return 0;

        int dp[][] = new int[coins.length][amount+1];

        for(int[] a : dp)
        {
            Arrays.fill(a, -1);
        }

        int res = findChange(coins.length-1, amount, coins, dp);
        return res;
    }

    public static int findChange(int ind, int amt, int[] coins, int[][] dp)
    {
        if(ind == 0)
        {
            if(amt !=0 && amt%coins[ind] == 0)
                return amt/coins[ind];
            else
                return -1;
        }

        if(amt == 0)
            return 0;

        if(dp[ind][amt] != -1) return dp[ind][amt];

        int np = findChange(ind-1, amt, coins, dp);

        int pick  = Integer.MAX_VALUE;

        if(amt >= coins[ind])
        {
            pick = 1 + findChange(ind, amt - coins[ind], coins, dp);
        }

        if(np == -1 && pick == -1 )
            return -1;
        else if(np == -1)
            return pick;
        else if(pick == -1)
            return np;

        return dp[ind][amt] = Math.min(np, pick);
    }

    public static void main(String[] args) {

        int[] input  = {1, 2};

        int amount = 2;

        int res = coinChange(input, amount);

        System.out.println(" the result is "+ res);
    }
}
