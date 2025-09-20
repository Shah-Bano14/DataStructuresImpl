package leetcode.Strings;

public class StringToInteger {
    public static void main(String[] args) {

        String input = "words and 987";
        int result = ConvertStringToInteger(input);
        System.out.println("the result is : "+ result);
    }

    private static int ConvertStringToInteger(String s) {
        long result =0;
        String s1 = "";

        for(int i=0;i<s.length();)
        {
            if(s.charAt(i)==' ' && s1.length()==0)
            {
                i++;
            }
            else if(s.charAt(i)==' ' && s1.length()!=0)
            {
                break;
            }
            else if(s.charAt(i)=='+'||s.charAt(i)=='-'){
                s1 = s1+s.charAt(i);
                i++;

            }
            else if(Character.isDigit(s.charAt(i)))
            {
                s1+=s.charAt(i);
                i++;
            }
            else if(!Character.isDigit(s.charAt(i)))
            {
                break;
            }
        }
        System.out.println(s1);
        if(s1.length()==0)
        {
            result=0;
        }
        else {

            result = Integer.parseInt(s1);
            if(result>Integer.MAX_VALUE)
            {
                result = Integer.MAX_VALUE;
            }
            if(result<Integer.MIN_VALUE)
            {
                result= Integer.MIN_VALUE;
            }
        }

        return (int)result;
    }
}
