package com.company;

import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args){
        int res = calculate("3+5 / 2 ");
        return;
    }
    public static int calculate(String s) {
        if(s.length() == 0)
            return 0;
        Stack<Character> stack = new Stack<>();
        Stack<Integer> resultStack = new Stack<>();
         s = s.replaceAll("\\s+", "");
        for(int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty()) {
                char c = stack.peek();
                switch(c){
                    case '*':
                        stack.pop();
                        char lInt = stack.pop();
                        char rInt = s.charAt(i);
                        char result = multiply(lInt, rInt);
                        stack.push(result);
                        break;
                    case '/':
                        stack.pop();
                        char numerator = stack.pop();
                        char denominator = s.charAt(i);
                        result = divide(numerator, denominator);
                        stack.push(result);
                        break;
                    default:
                        stack.push(s.charAt(i));
                }
            }else{
                stack.push(s.charAt(i));
            }
        }

        if(stack.size() == 1)
            return stack.pop()-'0';
        int r = 0;int l =0;
        resultStack.push(stack.pop() - '0');
        while(!stack.isEmpty()){
            char c = stack.pop();
            switch(c) {
                case '+':
                    l = stack.pop() - '0';
                    resultStack.push(l+resultStack.pop());
                    break;
                case '-':
                    l = stack.pop() - '0';
                    resultStack.push(l - resultStack.pop());
                    break;
            }
        }
        return resultStack.pop();
    }


    static char  multiply(char l, char r){

        int i = l - '0';
        int j = r - '0';
        char re = (char) ('0' + i*j);
        return re;

    }

    static char divide(char l, char r){

        int i = l - '0';
        int j = r - '0';
        char re = (char)('0' + i/j );
        return re;

    }
}
