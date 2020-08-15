package com.company.string;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        // write your code here
        String s = "AABABBA";


        int res = characterReplacement(s, 1);
        System.out.println(res);

    }
    public static int characterReplacement(String s, int k) {

        int left = 0; int right = 0; int repeat = 0; int max =0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {

            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) +1);
            repeat = Math.max(repeat, map.get(s.charAt(right)));

            if(right - left + 1 - repeat > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            max = Math.max(max, right - left +1);
            right++;
        }

        return max;
    }
}
