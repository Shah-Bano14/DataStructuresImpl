package src.main.java.MyCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ContainsDuplicateIIILT {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        HashMap<Integer, List<Integer>> hm=new HashMap<Integer,List<Integer>>();
        for(int i=0;i<nums.length;i++) {
            if(hm.containsKey(nums[i])) {
                List li = hm.get(nums[i]);
                li.add(i);
                hm.put(nums[i], li);
            }
            else {
                List li = new ArrayList();
                li.add(i);
                hm.put(nums[i], li);
            }
        }
        System.out.println(hm);
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++) {
        System.out.print(nums[i] + " "); }
        int i=nums.length-2, j=nums.length-1;
        for(;i>=0&&j>=0;)
        {
            if(Long.valueOf(nums[j])-Long.valueOf(nums[i]) <= t)
            {
                if((nums[j]-nums[i])!=0)
                {
                    if(Math.abs(hm.get(nums[j]).get(hm.get(nums[j]).size()-1)-hm.get(nums[i]).get(hm.get(nums[i]).size()-1))<= k)
                        return true;
                    else {

                        List<Integer> ans = hm.get(nums[j]);
                        ans.remove(ans.size()-1);
                        hm.put(nums[j],ans);
                    }

                }
                else {

                    List<Integer> ans = hm.get(nums[j]);
                    System.out.println("******** "+ ans);
                    for(int l=ans.size()-1;l>0;l--)
                    {
                        int x = ans.get(l);
                        System.out.println(" x = "+ x);
                        int y = ans.get(l-1);
                        System.out.println(" y = "+ y);
                        System.out.println("k is "+ k);
                        if((x-y) <= k)
                            return true;


                    }
                    ans.remove(ans.size()-1);



                }
            }

                j--;
                i--;

        }

        return false;
    }

    public static void main(String[] args) {

        int nums[] = {0,10,22,15,0,5,22,12,1,5};
        int k=3;
        int t=3;
   /*     long n1 = -2147483648;
        long n2 = 2147483647;
        System.out.println("diffff " + (n2-n1));*/
        Boolean flag = containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(flag + " *************");
    }
}
