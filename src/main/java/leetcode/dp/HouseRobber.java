package leetcode.dp;


import java.util.Arrays;

/*
A robber is targeting to rob houses from a street. Each house has security measures that alert the police when two adjacent houses are robbed. The houses are arranged in a circular manner, thus the first and last houses are adjacent to each other.
Given an integer array money, where money[i] represents the amount of money that can be looted from the (i+1)th house. Return the maximum amount of money that the robber can loot without alerting the police.
Input: money = [2, 1, 4, 9]
Output: 10
Explanation:
[2, 1, 4, 9] The underlined houses would give the maximum loot.
Note that we cannot loot the 1st and 4th houses together.


Logic: to handle the circular data for first and last ele, we do a trick:
 first calculated the max for non adjacent ele from first until 2nd last ele,
 then cal for 2nd to last ele.
 the ans is the max bwtween the two.

 why??? becuase the ans cannot contain both the first and the last element..... Yayyyyyyyyyyyyyyy.... huhuuuuuuuuuuuuuuu

 TC = O(n) for tab and mem , and 0(2'n) fopr rec
 SC =  o(N) for tab and mem, o(n+n) for rec
 */
public class HouseRobber {

    public static void main(String[] args) {

        int money[] = {2,7,9,3,1};
        int n = money.length;

        int temp1[] = new int[money.length-1];

        int temp2[] = new int[money.length-1];

        int k=0, l= 0;
        for(int i=0;i<money.length;i++)
        {
            if(i!=0)
            { temp1[k] = money[i]; k++;}
            if(i!=money.length-1)
            {
                temp2[l] = money[i];
                l++;
            }
        }

        int firstrec = recu(money.length-1, temp1);
        int secrec = recu(money.length-1, temp2);
        System.out.println("the recusion soln is : "+ Math.max(firstrec, secrec));

        int dp[] = new int[n-1];
        Arrays.fill(dp, -1);
        System.out.println("the memo soln is : "+ Math.max(memo(n-1, temp1, dp), memo(n-1, temp2, dp)));

        System.out.println("the tabulation sol is: " + Math.max(tabu(n-1, temp1), tabu(n-1, temp2)));

    }

    private static int tabu(int n, int[] temp1) {

        int dp[] = new int[n+1];

        dp[0] = 0;
        dp[1] = temp1[0];

        for(int i=2;i<n+1;i++)
        {
            int pick = temp1[i-1] + dp[i-2];

            int notPick = dp[i-1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[n];
    }

    private static int memo(int n, int[] money, int[] dp) {

        if(n<=0)
            return 0;

        if(dp[n-1] != -1)
            return dp[n-1];

        int notpick  = memo(n-1, money, dp);

        int pick = money[n-1] + memo(n-2, money, dp);

        return dp[n-1] = Math.max(notpick, pick);
    }

    private static int recu(int n, int[] money) {

        if(n <= 0)
            return 0;


        int notPick = recu(n-1, money);

        int pick = money[n-1] + recu(n-2, money);

        return Math.max(pick, notPick);

    }
}
