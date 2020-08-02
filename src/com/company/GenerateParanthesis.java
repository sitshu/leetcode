package com.company;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public static void main(String[] args){

       List<String> res =  generateParenthesis(3);
        return;
    }

    public static List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        char[] arr = new char[2 * n];
        arr[0] = '(';
        helper(res, 1, arr,1, 0,1, n);
        return res;
    }

    public static void helper(List<String> res, int length, char[] arr, int i, int closecount, int openCount, int n) {

        if (length == 2 * n)
            res.add(new String(arr));


       if(openCount<n ) {
           arr[i] = '(';
           helper(res, length + 1, arr, i+1, closecount, openCount+1,n);
       }
       if(closecount<openCount){
           arr[i] = ')';
           helper(res, length + 1, arr, i+1, closecount+1, openCount,n);
       }
    }

}
