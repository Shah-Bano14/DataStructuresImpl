package src.main.java.MyCode;

public class fibonacci {

    public static void main(String[] args) {

        int n = 10;
       // System.out.println(callFibo(n));
        for(int i=0;i<n;i++)
        {
            System.out.println(callFibo(i));
        }
    }

    public static int callFibo(int n) {
        if(n<=1)
            return n;
        else
            return callFibo(n-1) + callFibo(n-2);

    }
}
