package com.company.dp;

import java.util.ArrayList;
import java.util.List;

public class DecodeWays {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("leet");
        stringList.add("code");


        int result = numDecodings("12");
        System.out.println(result);
    }
    public static int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int[] dp = new int[s.length() +1];

        dp[0] = 1;
        if( '0' < s.charAt(0)  && '9' >= s.charAt(0) )
            dp[1] = 1;
        else
            dp[1] = 0;

        for(int i=2; i< s.length()+1; i++) {
            int onedigit = Integer.parseInt(s.substring(i-1, i));
            int twodigit = Integer.parseInt(s.substring(i-2, i));

            if(onedigit<=9 && onedigit >0)
                dp[i]+=dp[i-1];
            if(twodigit > 9 && twodigit < 27)
                dp[i]+=dp[i-2];
        }
        return dp[s.length()];
    }
}
