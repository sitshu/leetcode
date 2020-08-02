package com.company;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        // write your code here
        String s = "ADOBECODEBANC";
        String t = "ABC";


        String res = minWindow(s, t);
        System.out.println(res);

    }
    public static String minWindow(String s, String t) {

        if(t.length() == 0 ) {
            return "";
        }
        int rl = 0;
        int rr = 0;
        Map<Character, Integer> map = new HashMap<>();
        int lettersLeft = getCount(t, map);
        int length = -1;
        int left =0, right = 0;

        while(right<s.length()) {

            if(map.containsKey(s.charAt(right))) {
                int prev = map.get(s.charAt(right));
                if(prev==1) {
                    lettersLeft--;
                }
                map.put(s.charAt(right), --prev);

            }
            right++;

            while(lettersLeft==0 && left < right) {

                if(length ==-1 || length > right -left + 1) {
                    length = right - left +1;
                     rl = left;
                     rr = right;
                }
                if(map.containsKey(s.charAt(left))) {
                    int prev = map.get(s.charAt(left));
                    if(prev == 0) {
                        lettersLeft++;
                    }
                    map.put(s.charAt(left), ++prev);
                }
                left++;
            }

        }
        return length == -1? "": s.substring(rl, rr);

    }

    public static int getCount(String t, Map<Character, Integer> map) {
        for(int i=0; i<t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        return map.size();
    }
}
