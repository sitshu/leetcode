package com.company.dp;

import java.util.*;

public class WordBreak {


    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("leet");
        stringList.add("code");


        boolean result = wordBreak("leetcode", stringList);
        System.out.println(result);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> substringToBreakableMap = new HashMap<>();
        Set<String> set = new HashSet<>(wordDict);
        return isBreakable(s, set, substringToBreakableMap);
    }

    public static boolean isBreakable(String s, Set<String> set, Map<String, Boolean> map) {

        if(s.length()==0)
            return true;
        if(map.containsKey(s))
            return map.get(s);

        for(int i =0 ; i<=s.length(); i++){

            if(set.contains(s.substring(0,i)) && isBreakable(s.substring(i), set, map)) {

                map.put(s.substring(i), true);
                return true;
            }


        }
        map.put(s, false);
        return false;
    }
}
