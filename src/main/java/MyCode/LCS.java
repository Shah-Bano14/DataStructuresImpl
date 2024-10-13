package src.main.java.MyCode;

import java.util.ArrayList;
import java.util.List;

    public  class LCS {
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

