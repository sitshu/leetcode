package com.company.revision;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords {
    public static void main(String[] args) {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};

        List<String> result = findAllConcatenatedWordsInADict(words);
        return;

    }
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = new TrieNode();
        if(words == null || words.length == 0)
            return result;
        for(String word: words){
            if(word.length() == 0) continue;
            addWord(word, root);
        }

        for(String word: words) {
            if(word.isEmpty()) continue;

            if(testWord(word, 0, root, 0)) {
                result.add(word);
            }
        }
        return result;
    }
    public boolean testWord(char[] chars, int index, TrieNode root, int count) { // count means how many words during the search path
        TrieNode cur = root;
        int n = chars.length;
        for (int i = index; i < n; i++) {
            if (cur.sons[chars[i] - 'a'] == null) {
                return false;
            }
            if (cur.sons[chars[i] - 'a'].isEnd) {
                if (i == n - 1) { // no next word, so test count to get result.
                    return count >= 1;
                }
                if (testWord(chars, i + 1, root, count + 1)) {
                    return true;
                }
            }
            cur = cur.sons[chars[i] - 'a'];
        }
        return false;
    }
    public static boolean testWord(String word, int index,  TrieNode root, int count) {

        TrieNode node = root;
        for(int i=index; i<word.length(); i++) {
            char c = word.charAt(i);
            if(node.sons[c-'a'] == null)
                return false;
            if(node.sons[c-'a'].isEnd){
                if(index == word.length()-1)
                    return count>=1;

                if(testWord(word, i+1, root, count+1)) return true;
            }

            node = node.sons[c-'a'];
        }

        return false;
    }
    public static void addWord(String word, TrieNode node) {
        char[] arr = word.toCharArray();

        for(int i=0; i< word.length(); i++){

            if(node.sons[arr[i] - 'a'] == null)
                node.sons[arr[i]-'a'] = new TrieNode();
            node = node.sons[arr[i] -'a'];
        }
        node.isEnd = true;
    }
    static class TrieNode {
        TrieNode[] sons;
        boolean isEnd;
        public TrieNode() {
            sons = new TrieNode[26];
        }
    }
}



