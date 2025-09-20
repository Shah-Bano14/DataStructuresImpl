package leetcode.binarysearch;

public class Nthroot {

    public static int NthRoot(int n, int m) {
        // Write your code here.

        int result =-1;
        int low=0, high = m, mid=0;
        while(low<=high)
        {
            mid = (low+high) /2;
            double val = find(mid, n);
            if(val >(double)m)
                high = mid -1;
            else if(val < (double)m)
                low = mid+1;
            else
            { result = mid; break; }
        }


        return result;
    }

    public static double find(int mid, int n)
    {

        return Math.pow(mid, n);
    }


    public static void main(String args[])
    {
        int m= 27;
        int n=3;
        int result = NthRoot(n, m);

        System.out.println("the answer is "+ result);
    }
}
