package com.company.wepay;

import javafx.util.Pair;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Map<String, List<String>> allDict = new HashMap<>();
        for(String word: wordList){
            for(int i=0; i<word.length(); i++){

                String newString = word.substring(0, i) + "*" + word.substring(i+1);
                List<String> words =  allDict.getOrDefault(newString, new ArrayList<>());
                words.add(word);
                allDict.put(newString, words);
            }
        }

        Map<String, Boolean> visited = new HashMap<>();
        Queue<Pair<String,Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<String, Integer>(beginWord, 1));
        visited.put(beginWord, true);

        while(!queue.isEmpty()){
            Pair<String, Integer> pair = queue.poll();
            int level = pair.getValue();
            String word = pair.getKey();
            for(int i=0; i<word.length(); i++){
                String neighbor = word.substring(0, i)+ "*" + word.substring(i+1);
                List<String> adjacentList = allDict.getOrDefault(neighbor, new ArrayList<>());
                for(String adj: adjacentList){
                    if(adj.equals(endWord)){
                        return level+1;
                    }
                    if(!visited.getOrDefault(adj, false)){
                        visited.put(adj, true);
                        queue.offer(new Pair<String, Integer>(adj, level+1));
                    }
                }
            }
        }
        return 0;
    }
}
