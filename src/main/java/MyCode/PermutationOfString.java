package src.main.java.MyCode;

import java.util.HashSet;

public class PermutationOfString {

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
