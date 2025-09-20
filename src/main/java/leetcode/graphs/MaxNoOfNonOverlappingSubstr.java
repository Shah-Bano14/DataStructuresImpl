package leetcode.graphs;

import java.util.*;

public class MaxNoOfNonOverlappingSubstr {

    public static void main(String[] args) {
        String s = "adefaddaccc";

        List<String> result = maxNumOfSubstrings(s);
        for(int i=0;i<result.size();i++)
        {
            System.out.print(result.get(i) + " ");
        }

    }
    
        public static List<String> maxNumOfSubstrings(String s) {

            HashMap<String, PairStartEnd> pair = new HashMap<>();
            HashMap<Character, List<Integer>> hm = new HashMap<>();
            List<PairStartEnd> li = new ArrayList<PairStartEnd>();

            for(int i=0;i<s.length();i++)
            {
                char ch = s.charAt(i);
                if(hm.containsKey(ch))
                {
                    hm.get(ch).set(1, i);
                }
                else {
                    hm.put(ch, new ArrayList<>(Arrays.asList(i, i)));
                }
            }

            int start = hm.get(s.charAt(0)).get(0);
            int end = hm.get(s.charAt(0)).get(1);
            String s1 = "";

            findSub(0, -1, -1, s1, s, hm, pair);

            for(Map.Entry<String, PairStartEnd> entry: pair.entrySet())
            {
                System.out.println(entry.getKey());
                li.add(entry.getValue());
            }

            PairSort sort = new PairSort();
            Collections.sort(li, sort);

            List<String> res = new ArrayList<String>();
            int end1=-1;
            for(int i=0;i<li.size();i++)
            {

                System.out.println(li.get(i).s);
                if(i==0)
                {
                    res.add(li.get(i).s);
                    end1 = li.get(i).end;
                }
                else if(li.get(i).start > end1)
                {
                    res.add(li.get(i).s);
                }
            }

            return res;



        }

        public static void findSub(int ind, int start, int end, String s1, String s, HashMap<Character, List<Integer>> hm, HashMap<String, PairStartEnd> pair)
        {
            if(ind == s.length())
                return;

            //nottake
            if(end < hm.get(s.charAt(ind)).get(0))
            {

                if(s1!="" && pair.containsKey(s1)==false)
                {
                    PairStartEnd pair1 = new PairStartEnd(s1, start, end);
                    pair.put(s1, pair1);
                    s1="";

                }
                findSub(ind+1, -1, -1, "", s, hm, pair);
                start = ind;
                end = hm.get(s.charAt(ind)).get(1);
                s1 = s1+s.charAt(ind);
                findSub(ind+1, start, end, s1, s, hm, pair);

            }
            else {
                s1 = s1+ s.charAt(ind);
                if(hm.get(s.charAt(ind)).get(1) > end)
                    end = hm.get(s.charAt(ind)).get(1);
                findSub(ind+1, start, end, s1, s, hm, pair);
            }





        }
    }



    class PairStartEnd{

        String s;
        int start;
        int end;

        public PairStartEnd(String s, int start, int end)
        {
            this.s= s;
            this.start = start;
            this.end = end;
        }
    }

    class PairSort implements Comparator<PairStartEnd>
    {
        public int compare(PairStartEnd p1, PairStartEnd p2)
        {
            if(p1.end>p2.end)
                return 1;
            else if(p1.end<p2.end)
                return -1;
            else if(p1.start<=p2.start)
                return -1;
            else
                return 1;
        }
    }

