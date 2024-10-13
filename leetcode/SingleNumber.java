package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class SingleNumber {

    public static void main(String[] args) {

        int a[]= {2,2,5,3,3,4,4};
        if(a.length==1)
        {
            System.out.println(a[0]);
            return;
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<a.length;i++)
        {
            if(hs.contains(a[i]))
            {
                hs.remove(a[i]);
            }
            else{
                hs.add(a[i]);
            }
        }
        System.out.println(hs.iterator().next());
    }
}
