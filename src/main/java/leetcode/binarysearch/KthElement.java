package leetcode.binarysearch;

public class KthElement {

    public static void main(String[] args) {
        int arr1[] = {6, 6, 9, 10, 12, 12, 13, 13};
        int arr2[] = {6, 7, 9, 9, 12, 13};
        long ans = kthElement(arr1, arr2, 8, 6 , 9);
        System.out.println("the answer is "+ ans);


    }
    public static long kthElement( int arr1[], int arr2[], int n, int m, int k) {

        int  c=0, ele = -1;
//        if(arr1.length<arr2.length)
//            min = arr1.length;
//        else
//            min = arr2.length;
        int i=0, j=0;
        for(;i<arr1.length && j<arr2.length;)
        {
            if(arr1[i]<arr2[j])
            {
                ele = arr1[i];
                c++;
                i++;

            }
            else if( arr1[i]==arr2[j])
            {
                ele = arr2[j];
                c++;
                i++;


            }
            else{
                ele = arr2[j];
                j++;
                c++;

            }
            if(c==k)
            {
                return (long)ele;
            }

        }

        if(i<arr1.length)
        {
            int rem = k-c;
            ele = arr1[i+rem];
        }

        if(j<arr2.length)
        {
            int rem = k-c;
            ele = arr2[j+rem];
        }
        return (long)(ele);
    }
}
