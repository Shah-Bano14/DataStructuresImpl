package leetcode;

import java.util.Arrays;

public class RotateArray {
    public static void rotateWithTLE(int[] nums, int k) {
        if(k>nums.length)
        {
            k=k%nums.length;
        }
        if(k==0 || k==nums.length)
        {
            for(int i=0;i<nums.length;i++)
            {
                System.out.println(nums[i]);
            }
            return;
        }
        String s= String.valueOf(nums[0]);
        String s1= String.valueOf(nums[nums.length-k]);
        for(int i=1;i<nums.length;i++)
        {
            if(i==nums.length-k)
            {
                continue;
            }
            if(i<nums.length-k) {
                s = s + "," + nums[i];
                s.trim();
            }
            else {
                s1=s1+","+nums[i];
                s1.trim();
            }

        }
        s= s1+","+s;
        String c[] = s.trim().split(",");

        for(int i=0;i<c.length;i++)
        {
            nums[i] = Integer.parseInt(c[i]);
        }
        for(int i=0;i<c.length;i++)
        {
            System.out.println(nums[i]);
        }





    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        int k=7;
        //rotateWithTLE(a, k);
        rotateWithoutTLE(a,k);
    }

    public static void rotateWithoutTLE(int[] nums, int k)
    {
        if(k==0 || k==nums.length)
        {
            //no rotation
            for(int i=0;i<nums.length;i++)
            {
                System.out.println(nums[i]);
            }
            return;
        }
        if(k>nums.length)
        {
            k=k%nums.length;
        }
        int a[] = new int[nums.length];
        int j=0;
        for(int i=nums.length-k;i< nums.length;i++)
        {
            a[j]=nums[i];
            j++;
        }
        for(int i=0;i<nums.length-k;i++)
        {
            a[j]=nums[i];
            j++;
        }

        for(int i=0;i<nums.length;i++)
        {
            nums[i]=a[i];
        }
        for(int i=0;i<nums.length;i++)
        {
            System.out.println(nums[i]);
        }



    }
}
