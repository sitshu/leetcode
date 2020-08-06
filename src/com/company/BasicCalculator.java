package com.company;

import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args){
        int res = calculate("3+2*2 ");
        return;
    }
    public static int calculate(String s) {
        int len;
        if(s==null)
            return 0;
        s  = s.replaceAll("\\s+", "");
        if((len = s.length())==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        char sign = '+';

        int num = 0;
        for(int i=0 ;i< len ; i++) {
            if(Character.isDigit(s.charAt(i)))
                num = num*10 + (s.charAt(i) - '0');
            if((!Character.isDigit(s.charAt(i)) ) || i == len-1) {
                if(sign == '-'){
                    stack.push(-num);
                }
                if(sign == '+')
                    stack.push(num);
                if(sign == '*')
                    stack.push(stack.pop()*num);
                if(sign=='/')
                    stack.push(stack.pop()/num);

                sign = s.charAt(i);
                num=0;
            }
        }

        int res = 0;
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return 0;
    }
}
