package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArray {
    public static int[] intersect(int[] nums1, int[] nums2) {
        //arrays are not null
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //int length=0;
        List<Integer> li = new ArrayList<>();
       /* if(nums1.length > nums2.length)
        {
            length = nums2.length;
        }
        else {
            length = nums1.length;
        }*/
        for(int i=0,j=0;i<nums1.length && j<nums2.length;)
        {
            if(nums1[i]==nums2[j])
            {
                li.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]>nums2[j])
            {
                j++;
            }
            else if(nums1[i]<nums2[j])
            {
                i++;
            }

        }
        int result[] = new int[li.size()];
        for(int i=0;i<li.size();i++)
        {
            result[i]=li.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int nums1[] = {1,2,2,1};
        int nums2[] = {2,2};
        int a[] = intersect(nums1, nums2);
        System.out.println("the output is ");
        if(a.length==0)
            System.out.println(0);
        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }
    }
}
