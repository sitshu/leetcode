package com.company.revision;

import java.util.*;

public class WordLadderII {
        public static void main(String[] args) {
            String[] s = {"hot","dot","dog","lot","log","cog"};
            List<String> words = new ArrayList<>(Arrays.asList(s));
            findLadders("hit", "cog", words);
        }

    public  static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result= new ArrayList<>();
        Map<String, List<List<String>>> map= new HashMap<>();
        List<String> init = new ArrayList();
           init.add(beginWord);
            map.put(beginWord, new ArrayList());
            map.get(beginWord).add(init);
        Set<String> start = new HashSet<>();
        Set<String> words = new HashSet<>(wordList);
        start.add(beginWord);
        boolean found = false;
        while(!start.isEmpty() && !found && !wordList.isEmpty()) {
            words.removeAll(start);
            Set<String> newStart = new HashSet<>();
            for(String s: start) {
                char[] ch = s.toCharArray();
                List<List<String>> endPath  = map.get(s);
                for(int i=0; i<s.length(); i++) {
                    for(char c ='a'; c<='z'; c++){
                        if(ch[i] == c) continue;
                        char oldchar = ch[i];
                        ch[i] = c;
                        String newWord = new String(ch);
                        if(words.contains(newWord)) {
                            newStart.add(newWord);
                            for(List<String> path: endPath){
                                List<String> nextPath = new ArrayList(path);
                                nextPath.add(newWord);
                                List<List<String>> paths = map.getOrDefault(newWord, new ArrayList<>());
                                paths.add(nextPath);
                                map.put(newWord, paths);
                                if(newWord.equals(endWord)){
                                    found = true;
                                    result.add(nextPath);
                                }
                            }
                        }
                        ch[i] = oldchar;
                    }

                }
                map.remove(s);
            }
            start.clear();
            start.addAll(newStart);
        }
        return result;

    }
        public static List<List<String>> findLaddersII(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> res = new ArrayList();
            Set<String> words = new HashSet(wordList);

            Set<String> start = new HashSet();
            start.add(beginWord);
            boolean found = false;

            // use hashMap to store all possible route ending at key
            Map<String, List<List<String>>> map = new HashMap();
            List<String> init = new ArrayList();
            init.add(beginWord);
            map.put(beginWord, new ArrayList());
            map.get(beginWord).add(init);



            while(!words.isEmpty() && !found && !start.isEmpty()){
                // eliminate all previous layer words from dict
                words.removeAll(start);
                // use another set to record next layers' words
                Set<String> newStart = new HashSet();

                // iterate through all new starts
                for(String s: start){
                    char[] chs = s.toCharArray();
                    List<List<String>> endPath  = map.get(s);
                    for(int i=0;i<chs.length;i++){
                        // randomly change a character
                        for(char ch='a';ch<='z';ch++){
                            if(chs[i]==ch) continue;
                            char tmp = chs[i];
                            chs[i] = ch;
                            String word = new String(chs);
                            //check if it is in the dict, if so new start found, extending all routes
                            if(words.contains(word)){
                                newStart.add(word);
                                for(List<String> path:endPath){
                                    List<String> nextPath = new ArrayList(path);
                                    nextPath.add(word);
                                    map.putIfAbsent(word, new ArrayList());
                                    map.get(word).add(nextPath);
                                    if(word.equals(endWord)){
                                        found = true;
                                        res.add(nextPath);
                                    }
                                }

                            }
                            chs[i] = tmp;
                        }
                    }
                    map.remove(s);
                }
                // clear the previous layers words and update
                start.clear();
                start.addAll(newStart);

            }

            return res;
        }


}
