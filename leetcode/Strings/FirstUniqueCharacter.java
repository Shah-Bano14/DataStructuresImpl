package leetcode.Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FirstUniqueCharacter {

    public static void main(String[] args) {
        String s = "loveleetcode";
        int index = findTheFirstUniqueChracter(s);
        System.out.println("the index is : "+ index);
    }

    private static int findTheFirstUniqueChracter(String s) {

        HashMap<Character, Integer> hm = new HashMap<>();
        int index=-1;
        for(int i=0;i<s.length();i++)
        {
            if(hm.containsKey(s.charAt(i)))
            {
                hm.put(s.charAt(i),-1);
            }
            else {
                hm.put(s.charAt(i),i);
            }
        }

        for(Map.Entry<Character,Integer> entry: hm.entrySet())
        {
            if(entry.getValue()>=0)
            {
                if(index==-1)
                {
                    index= entry.getValue();
                }
                else if(entry.getValue()<index)
                {
                    index= entry.getValue();
                }
            }
        }

        return index;
    }
}

