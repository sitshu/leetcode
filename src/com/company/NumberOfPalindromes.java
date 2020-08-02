package com.company;

public class NumberOfPalindromes {

    public static void main(String[] args) {
        // write your code here
        String s = "ab";


        int res = countSubstrings(s);
        System.out.println(res);

    }

    public static int countSubstrings(String s) {
        if(s.length() == 2)
            return 0;
        int n = s.length();
        int ans = 0;
        for(int i=0; i< n; i++) {
            ans+= checkPalindromes(i, i, s);
            ans+= checkPalindromes(i, i+1, s);
        }
        return ans;
    }

    public static int checkPalindromes(int l, int r, String s) {

        int ans = 0;
        while(r < s.length() && l >=0 && s.charAt(l) == s.charAt(r) ) {
            ans++;
            l--;
            r++;
        }
        return ans;

    }
}
