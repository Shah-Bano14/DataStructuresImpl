package leetcode.dp;

import java.util.Stack;

public class FindLongestParanthesis {

    public static void main(String[] args) {
        String input = "))))())(())()))(()()(())(())()))(((()()))()()))(())(())()())()(()())((()(((())()())(()())(())((()))))())()))()(())))())()))(()))((()())((()(())))(()))))))))((())(()()((())()()(()))))(((()(())))())))()())))())()()())()(())()(((())()))()()())))()())))()((((((())((())))((())())(((()())())()((((((()())((()()(())(()))(()())()))()(()(()())(()))((())((())))))()()))))()())()))))((((())(())))((()))(()()()()()((())((((())())()())()())(()(()()))())(((()())(()))()))(())()((()(())))))()())())()()(())))((())()()()))(())((()())))))((()((((()(((())()))))(()))()()))(()(())(()((()()()))))()))()()(((()()(())())()(())(()()()))()(()())))()((()((()))))())()(())()(()()((()()())(((())((())))(()())))()))()()())()))((()))(((()()()((()))))()()()))()))())())))))())()))(()))))(()()()))()((())))((())))()))(()()()()()()(()))())())(((())))(())(()(()())((()()()()))()()(()()))(()())(()()()((()()(((()(()((()((((()((())((()()))))))()())())(()(())()((((()()()()()))))()())()((())))))))()(((()())))()(()()(()()()()))()((((()((())(())))())))(()()()())()))))))((()))())((())(()(()(((()()()((((()()))())()())()())()))))())()(((()))))()()())))(())())))(())())((()))(())))(((()()))((((()))(()()))())((()())(()))(()(())(()(()))((((((()()(()()(()))()(()(())((((((((()(()())((())))())()())(()(()()))))(()(()()()))(()((()(((())((())(())()(()()())(()))())((()((((((())())(())()(()()(()())(())())()()))())(()))(())))()())))()()((()))())()()(())(()())()())())())))()()))((((()((()(())(((())()((())(())())))))()(()))())()))())(((())))))((((()(()()))))(((())(((())((())))))()()))()(()(((((((()))))((()))())()(())()))())())((()))))((())(())))(((())((((()(())(())()(((((())))()))()(()())(()()(())()(((()))())())))()))()()())((";
        int res = longestValidParentheses(input); // method 1: shows tle for 5 test cases, passed 125/ 131
        System.out.println("the result is " + res);

        // method 2:
        int open=0, close=0, mx=0;

        // handles string which are valid from front ")()()"
        for(char ch : input.toCharArray()){
            if(ch=='(') open++;
            else close++;

            if(open==close) mx = Math.max(open+close,mx);
            else if(close>open) {open=0; close=0;}
        }

        // handles strings which are valid from back eg = "(()(()"
        open=0;close=0;
        for(int i=input.length()-1; i>=0; i--){
            if(input.charAt(i)==')') close++;
            else open++;
            if(open==close) mx = Math.max(open+close,mx);
            else if(open>close) {close=0;open=0;}
        }

        System.out.println("the ouput from second method is " + mx);
    }

        public static int longestValidParentheses(String s) {


            if (s.length() < 2)
                return 0;


            return findLongest(0, s, 0);

        }

        public static int findLongest(int i, String s, int length) {
            if (i >= s.length())
                return length;

            while (i<s.length()) {
                if (s.charAt(i) == ')')
                    i += 1;
                else
                    break;
            }

            for (int ind = i + 1; ind < s.length(); ind++) {
                if ((ind - i + 1) > length) {
                    if (checkValid(i, ind, s)) {
                        length = ind - i + 1;
                    }
                }
            }


            length = findLongest(i+1, s, length);
            return length;
        }

        public static boolean checkValid(int start, int end, String s) {
            Stack<Character> st = new Stack<>();

            if (s.charAt(start) == ')')
                return false;

            st.push(s.charAt(start));
            int i = start + 1;
            while (i <= end) {
                if (s.charAt(i) == '(')
                    st.push('(');
                else if (!st.isEmpty() && s.charAt(i) == ')')
                    st.pop();
                else
                    return false;

                i++;
            }

            if (st.isEmpty())
                return true;

            return false;


    }
}
