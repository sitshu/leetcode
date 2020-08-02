//package com.company.graph;
//
//import javafx.util.Pair;
//
//import java.util.*;
//
//public class WordLadder {
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//
//        int length = beginWord.length();
//        Map<String, List<String>> map = new HashMap<>();
//
//        wordList.forEach( word -> {
//            for(int i = 0; i< word.length(); i++) {
//
//                String newString = word.substring(0, i) + "*" + word.substring(i+1, length);
//                List<String> words = map.getOrDefault(newString, new ArrayList<>());
//                words.add(word);
//                map.put(newString, words);
//            }
//        });
//        Map<String, Boolean> visited = new HashMap<>();
//        Queue<Pair<String, Integer>> queue = new LinkedList<>();
//        visited.put(beginWord, true);
//
//        queue.add(new Pair(beginWord, 1));
//
//        while(!queue.isEmpty()){
//            Pair<String, Integer> pair = queue.poll();
//            String word = pair.getKey();
//            int level = pair.getValue();
//            for(int i = 0; i< word.length(); i++) {
//                String transformation = word.substring(0,i) + "*" + word.substring(i+1, length);
//                List<String> adjacentList = map.getOrDefault(transformation, new ArrayList<>());
//
//                for(String adjacent: adjacentList){
//                    if(adjacent.equals(endWord))
//                        return level+1;
//                    if(!visited.getOrDefault(adjacent, false)){
//                        visited.put(adjacent, true);
//                        queue.add(new Pair(adjacent, level+1));
//                    }
//                }
//
//            }
//
//        }
//        return 0;
//
//    }
//}
