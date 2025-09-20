package leetcode.Strings;

public class DecodedStringAtIndex {
//    You are given an encoded string s. To decode the string to a tape, the encoded string is read one character at a time and the following steps are taken:
//
//    If the character read is a letter, that letter is written onto the tape.
//    If the character read is a digit d, the entire current tape is repeatedly written d - 1 more times in total.
//    Given an integer k, return the kth letter (1-indexed) in the decoded string.
    public static void main(String[] args) {

        String s = "a2345678999999999999999";
        int k = 1;

        String ans = findtheIndex(s,k);
        System.out.println("the answer is : "+ ans);

    }

    private static String findtheIndex(String s, int k) {
        String s1="", s2="";
        for(int i =0;i<s.length();i++)
        {
            if(Character.isLetter(s.charAt(i)))
            {
                s1+=s.charAt(i);
            }
            else if(Character.isDigit(s.charAt(i)))
            {
                int l = Integer.parseInt(String.valueOf(s.charAt(i)));
                while(l-1>0)
                {
                    s1 +=s1;
                    l--;
                }
            }
        }
        s2 = String.valueOf(s1.charAt(k-1));
        return s2;
    }
}
