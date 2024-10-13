package src.main.java.MyCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GenerateBinaryString {
    public static class FrequencyOfChar {

        public static void main(String[] args) {

        }
    }

    public static class LCS {
        //find lcs in the set of array of strings
        List<String> li = new ArrayList<String>();
        public static void main(String args[]) {
            String array[] = {"sadness", "sadly", "sad", "ide"};
            String smallest = "";
            int index = 0, length = Integer.MAX_VALUE;
            for (int i=0;i<array.length;i++)
            {
                if(array[i].length() < length) {
                    length = array[i].length();
                    index = i;
                }
            }
            System.out.println(" smallest element = " + array[index]);
            LCS l = new LCS();
            l.findAllsubsequence(array[index]);
            l.printAll();
            String res = l.findSubs(array);
            System.out.println("the result is : " + res);

        }

        public void findAllsubsequence(String a) {

            for(int i=0;i<a.length();i++) {
                for(int j=i+1;j<=a.length();j++) {
                    li.add(a.substring(i,j));
                }
            }
        }

        public String findSubs(String arr[]) {

            String res ="";
            for(int i=0;i<li.size();i++)
            {

                int j=0;
                for(j=0;j< arr.length;j++)
                {
                    if(!arr[j].contains(li.get(i)))
                        break;
                }
                if(j== arr.length && res.length()<li.get(i).length())
                {
                    res = li.get(i);
                }
            }
            return res;
        }

        public void printAll() {
            for(int i=0;i< li.size();i++)
            {
                System.out.println(li.get(i));
            }
        }
    }

    public static class PermutationOfString {

        static int count = 0;

        public static void main(String[] args) {

            HashSet<Integer> h = new HashSet<>();

            String stringToPermute = "abcde";
            String answer ="";
            permute(stringToPermute, answer );
            System.out.println(count);
        }

        private static void permute(String stringToPermute, String answer) {

            if(stringToPermute.length() == 0)
            {
                System.out.println(answer);
                count++;
            }

            for(int i=0;i<stringToPermute.length();i++)
            {
                char ch = stringToPermute.charAt(i);
                String left = stringToPermute.substring(0,i);
                String right = stringToPermute.substring(i+1);
                String rest = left + right;
                permute(rest, answer+ch);
            }
        }
    }

    public static class QuickSort {
        public static int partition(int l , int r, int a[]) {

            int pivot = r;
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

    public static class reverseString {

        public static void main(String args[]) {
            String name = "Shah applied for MACS";
            String reversedString = "";
            for (int i=0;i< name.length(); i++)
            {
                reversedString = name.charAt(i)+reversedString;
            }

            System.out.println("The reversed string is :" + reversedString);

        }
    }
}
