package com.company.revision;

import java.util.*;
import java.util.stream.Collectors;

public class AlienDictionary {

    public static void main(String[] args) {
        String[] words = {
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };

        String result = alienOrder(words);

    }
    public static String alienOrder(String[] words) {
        int currpriority =0;
        Map<Character, List<Character>> adjList = new HashMap<>();
        HashMap<Character, Integer> characters = new HashMap<>();
        for(String word: words) {
            for(int i=0; i< word.length(); i++) {
                if(!characters.containsKey(word.charAt(i))){
                    characters.put(word.charAt(i), 0);
                    adjList.put(word.charAt(i), new ArrayList<>());
                }
            }
        }

        for(int i=0; i < words.length-1; i++) {

            String word1 = words[i];
            String word2= words[i+1];

            if(word1.length()>word2.length() && word1.startsWith(word2))
                return "";

            for(int j=0; j<Math.min(word1.length(), word2.length()); j++){

                if(word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    characters.put(word2.charAt(j), characters.get(word2.charAt(j))+1 );
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();

        for(Character ch: characters.keySet()){
            if(characters.get(ch) ==0) {
                queue.add(ch);
            }
        }

        while(!queue.isEmpty()) {
            Character c = queue.poll();
            sb.append(c);
            for(Character next: adjList.get(c)) {
                characters.put(next, characters.get(next) -1);
                if(characters.get(next) == 0)
                    queue.add(next);
            }
        }

        if(sb.length() < characters.size())
            return "";
        return sb.toString();

    }
}
