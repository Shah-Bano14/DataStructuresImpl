package leetcode.Strings;

public class ReverseInteger {
    public static void main(String[] args) {
        long n=(long)(1534236469);
        int result = reverseInteger(n);
        System.out.println(result);
        
    }

    private static int reverseInteger(long x) {

        if(x==0) {
            return 0;
        }
        long r;
        long s=0;
        while(x!=0)
        {
            r=x%10;
            s=s*10+r;
            x=x/10;
        }
        if(s>= Integer.MAX_VALUE || s<= Integer.MIN_VALUE)
        {
            return 0;
        }else {
            return (int)s;
        }

    }
}
