package com.company;

public class VerifyingAlienDictionary {

    public static void main(String[] args) {
        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        boolean result  = isAlienSorted(words, order);
        return ;


    }

    public static boolean isAlienSorted(String[] words, String order) {
        int[] ordered = new int[order.length()];
        char[] orderArray = order.toCharArray();

        for (int i = 0; i < orderArray.length; i++) {
            ordered[orderArray[i] - 'a'] = i;
        }

        if (words.length < 2)
            return true;
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int min = Math.min(word1.length(), word2.length());
            for (int k = 0; k < min; k++) {
                if (ordered[word1.charAt(k) - 'a'] > ordered[word2.charAt(k) - 'a'])
                    return false;
            }

            if (word1.length() > word2.length())
                return false;
        }


        return true;
    }


}
