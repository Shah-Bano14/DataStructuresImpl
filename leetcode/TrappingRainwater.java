package leetcode;

public class TrappingRainwater {

    public static void main(String[] args) {

        int a[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = trap(a);
        System.out.println(" the result is "+ res);
    }

    public static int trap(int[] height) {
        int count=0;
        for(int i=2;i<height.length;i++)
        {
            int left = i-2;
            int mid = i-1;
            int right= i;

            if(Math.abs(height[right]-height[left])>height[mid])
            {
                count += Math.abs(height[right]-height[left]) - height[mid];
            }
        }

        return count;

    }




}
