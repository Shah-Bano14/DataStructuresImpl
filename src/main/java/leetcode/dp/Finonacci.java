package leetcode.dp;

/*
tc: O(N)
SC: (n)
with this tabulation approach: no recursion stack space used
 */
public class Finonacci {

    public static void main(String[] args) {

        int n  =  5;
        int res = findFibonacci(n);
        System.out.println("the value is "+ res);
    }

    private static int findFibonacci(int n) {

        int dp[] = new int[n];
        dp[0]= 0; dp[1]= 1;

        for(int i=2;i<n;i++)
        {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
}
