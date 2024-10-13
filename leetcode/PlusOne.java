package leetcode;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        int a[] = {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
       // generatePlusOneOutputMethod1(a);
        generatePlusOneOutputMethod2(a);

    }

    private static void generatePlusOneOutputMethod2(int[] a) {

        int carry=0;
        for(int i= a.length-1;i>=0;i--)
        {
            if(a[i]==9 && i==a.length-1)
            {
                a[i]=0;
                carry=1;
            }
            else if(a[i]!=9 && i==a.length-1)
            {
                a[i] +=1;
                carry=0;
            }
            else if(a[i]==9 && carry==1)
            {
                a[i]=0;
                carry =1;
            }
            else if(a[i]!=9 && carry ==1) {
                a[i] += 1;
                carry = 0;
            }
        }
        int res[];
        if(carry ==1)
        {
            res = new int [a.length+1];
            res[0]=1;

        }
        else{
            res= a;
        }
        for(int i=0;i<res.length;i++)
        {
            System.out.print(res[i]);
        }
    }

    private static void generatePlusOneOutputMethod1(int[] a) {
        String s = Arrays.toString(a).replaceAll("[\\[\\],\\s]+","");
        System.out.println(s);
        int len1 = s.length();
        long num = Long.parseLong(s) + 1;  //giving number format exception as the string input can be really big
        int len2 = String.valueOf(num).length();
        int res[];
        if(len2>len1)
        {
            res = new int[len2];
        }
        else {
            res = new int[len1];
        }
        int k = res.length;
        while(num>0)
        {
            res[k-1] = (int)(num%10);
            k--;
            num /= 10;
        }

        for(int i=0;i<res.length;i++)
        {
            System.out.println(res[i]);
        }

    }
}
