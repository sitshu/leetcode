package com.company;

import java.util.HashMap;
import java.util.Map;

public class WordExist {

    public static void main(String[] args) {

       String s = "pwwkew";
         int length = lengthOfLongestSubstring(s);

    }
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        if(s.isEmpty())
            return 0;
        int left = 0;
        int right = 1;
        int length =1;
        int maxLength = 1;
        map.put(s.charAt(left), 0);
        while(right < s.length()){
            Character c = s.charAt(right);
            if(map.containsKey(c)) {
                Integer i =  map.get(c);
                left = i+1;
                map.put(c, right);
                if(right - left > 0)
                    length = left -right ;
                else
                    length = 1;
                right++;

            } else {
                map.put(c, right);
                length ++;
                right++;
                maxLength = maxLength > length ? maxLength : length;
            }

        }

        return maxLength;
    }
}
