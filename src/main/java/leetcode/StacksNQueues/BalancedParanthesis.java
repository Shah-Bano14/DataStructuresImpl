package leetcode.StacksNQueues;

import java.util.Stack;

public class BalancedParanthesis {

    public static void main(String[] args) {

        String input = "[[{()}]";

        Boolean result = checkBalancedParanthesis(input);

        if(result)
        {
            System.out.println("balanced");
        }
        else{
            System.out.println("unbalanced");
        }
    }

    private static Boolean checkBalancedParanthesis(String input) {

        Stack<Character> st =new Stack<>();
//        for(int i=0;i<input.length();i++)
//        {
//            st.add(input.charAt(i));
//        }

        int l=0;
        while(l<input.length())
        {
            char ch = input.charAt(l);
            if(ch == '{' || ch == '[' || ch == '(') st.add(ch);
            else {
                if(st.isEmpty())  // checks if there is no more opening braces in stack
                    return false;
                char top = st.peek();
                if ((top == '{' && ch == '}') || (top=='[' && ch == ']' ) || (top == '(' && ch == ')'))
                {
                    st.pop();
                }
                else
                    return false;
            }
            l++;
        }

        //test case to consider if extra opening braces present
        if(!st.isEmpty())
            return false;

        return true;
    }
}
