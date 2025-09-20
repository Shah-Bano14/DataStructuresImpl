package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveZeroes {
    static final int a[]= {0,1,0,3,12};
    public static void main(String[] args) {

       // moveZeroesMethod1(a);
        moveZeroesMethod2(a);}

    private static void moveZeroesMethod2(int[] a) {
        List<Integer> li = new ArrayList<>();
        int count=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]!=0)
            {
                li.add(a[i]);
            }
            else if(a[i]==0)
            {
                count++;
            }
        }
        for(int i=0;i<count;i++)
        {
            li.add(0);
        }
        a = li.stream().mapToInt(Integer::intValue).toArray();
        for(int i=0;i<a.length;i++)
        {
            System.out.print(a[i]);
        }


    }

    //this method doesnt cover double digit numbers
    private static void moveZeroesMethod1(int[] a) {
        String s1 = Arrays.toString(a).replaceAll("[\\[\\],\\s]+","");
        int l = s1.length();
        String s2 = s1.replaceAll("0","");
        int diff = l - s2.length();
        StringBuilder builder = new StringBuilder(s2);
        for(int i=0;i<diff;i++)
        {
            builder.append('0');
        }
        String result = builder.toString();
        int resultArray[] = new int[result.length()];
        for(int i=0;i<resultArray.length;i++)
        {
            resultArray[i] = Character.getNumericValue(result.charAt(i));
        }
        for(int i=0;i<a.length;i++)
        {
            a[i]=resultArray[i];
        }
        for(int i=0;i<a.length;i++)
        {
            System.out.print(a[i]);
        }

    }
}
