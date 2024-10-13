package src.main.java.MyCode;

public class QuickSort {
    public static int partition(int l , int r, int a[]) {

        int pivot = a[r];
        int i = l-1;

        for(int j=l; j<=r-1 ; j++)
        {
            if(a[j]<pivot)
            {
                i++;
                swap(i, j, a);
            }
        }

        swap(i+1, pivot , a);
        return i+1;

    }

    public static void swap(int i, int j, int a[]) {
        int temp = a[i];
        a[i] = a[j];
        a[j] =temp;
    }

    static void quicksort(int l, int r, int a[]) {
        if(l<r) {
        int p = partition(l, r, a);
        quicksort(l, p-1, a);
        quicksort(p+1, r, a); }
    }
    public static void main(String[] args)
    {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;

        quicksort(0, n - 1, arr);
        System.out.println("Sorted array: ");
        printArray(arr, n);
    }

    static void printArray(int[] arr, int size)
    {
        for(int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

}
