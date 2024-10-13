package leetcode.dp;

public class LongestPalinSubstring {

    public static String longestPalindrome(String s) {

        String s1="";
        String res = findPalin(0, s, s1);

        return res;
    }

    public static String findPalin(int i, String s, String s1)
    {
        if(i==s.length())
        {
            return s1;
        }

        for(int ind = i; ind< s.length(); ind++)
        {
            if(checkPalin(i, ind, s))
            {
                if(s1.length() < (ind-i)+1)
                {
                    s1 = s.substring(i, ind+1);
                }
            }
        }

        s1 = findPalin(i+1, s, s1);

        return s1;

    }

    public static boolean checkPalin(int start, int end, String s)
    {
        for(int i=start, j = end; i<=j; )
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "babad";
        String res = longestPalindrome(input);
        System.out.println("the result is " + res);

    }
}
