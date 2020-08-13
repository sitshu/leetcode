package com.company.amazon;

import java.util.*;
import java.util.stream.Collectors;

public class FeatureRequestsFrequency {

    public static void main(String[] args) {

        String[] set = {"betacellular", "anacell", "cetracular", "deltacellular", "eurocell"};
        String[] sentences = {"I love anacell best services provided by anacell in the town",
        "betacellular has great service", "deltacellular betacellular",
                "cetracular eurocell", "betacellular deltacellular",};
        List result = getFrequency(5, 2, set, 5, sentences);
        return;
    }

    public static ArrayList<String> getFrequency(int setSize, int k,  String[] dict,  int size, String[] sentences) {


        List<String> result = new ArrayList<>();
        Set<String> dictSet = new HashSet<>();
        for(String s:dict)
        {
            dictSet.add(s.toLowerCase());
        }
        Map<String, Integer> frequency = new HashMap<>();
        for(String sentence: sentences) {
            String[] words = sentence.toLowerCase().split("\\s+");
            Set<String> seen = new HashSet<>();
            for(String word: words) {
                if(dictSet.contains(word) && !seen.contains(word)) {
                    frequency.put(word, frequency.getOrDefault(word, 0) + 1);
                    seen.add(word);
                }
            }
        }


        ArrayList<String> ls = new ArrayList<>(frequency.keySet());
        Collections.sort(ls,
                (a, b) -> (frequency.get(a)).equals(frequency.get(b)) ? a.compareTo(b) : frequency.get(b) - frequency.get(a));
        if(k>setSize && k >ls.size()){
            return ls;
        }
        return new ArrayList<>(ls.subList(0, k));
    }
}
