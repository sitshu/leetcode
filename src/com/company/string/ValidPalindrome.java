package com.company.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean palindromic = isPalindrome(s);
    }

    public static boolean isPalindrome(String s) {

        if(s.length() == 0) {
            return true;
        }

        Pattern pt = Pattern.compile("[^a-zA-Z0-9]");
        Matcher match= pt.matcher(s);
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(s);
        return true;
    }
}
