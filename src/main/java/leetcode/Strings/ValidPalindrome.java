package leetcode.Strings;

public class ValidPalindrome {

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";


        boolean result = findIfValidPalindrome(s);
        System.out.println("the result is : "+ result);
    }

    private static boolean findIfValidPalindrome(String s) {
        String s1 = s.toLowerCase();
        boolean flag = true;
        for(int i=0,j=s.length()-1;i<s1.length()&&j>=0;)
        {
            if(!Character.isLetterOrDigit(s1.charAt(i)))
            {
                i++;
            }
            else if(!Character.isLetterOrDigit(s1.charAt(j))) // else of added to avoid index out of bound error
            {
                j--;
            }
            else if(Character.isLetterOrDigit(s1.charAt(i)) && Character.isLetterOrDigit(s1.charAt(j)))
            {
                if(s1.charAt(i)!=(s1.charAt(j)))
                {
                    flag = false;
                    break;
                }
                else {
                    i++;
                    j--;
                }
            }
        }


        return flag;
    }
}
