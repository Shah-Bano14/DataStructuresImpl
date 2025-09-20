package leetcode;

import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int nums[] = {2,7,11,15};
        int target = 9;
        findTwoaSum(nums, target);
    }

    private static void findTwoaSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int a[] = new int[2];
        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(target - nums[i]))
            {
                a[0]=i; a[i] = hm.get(target-nums[i]);
                break;
            }
            else {
                hm.put(nums[i], i);
            }
        }

        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }
    }
}
