package com.company.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {


    static class  Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();

        }
        /** Initialize your data structure here. */
        public  class TrieNode {
            private TrieNode[] links;
            private final int R = 26;
            private boolean isEnd = false;

            public TrieNode() {
                links = new TrieNode[R];
            }
            public boolean containsKey(char ch) {
                return links[ch - 'a'] !=null;
            }

            public void put(char ch, TrieNode node) {
                links[ch-'a'] = node;
            }
            public TrieNode get(char ch) {
                return links[ch-'a'];
            }

            public void setEnd() {
                isEnd = true;
            }
            public boolean isEnd() {
                return isEnd;
            }


        }

        /** Inserts a word into the trie. */
        public void insert(String word) {

            int length = word.length();
            TrieNode node = root;
            for(int i=0; i<length; i++) {
                char curr = word.charAt(i);
                if(!node.containsKey(curr)){
                    node.put(curr, new TrieNode());
                }
                node = node.get(curr);
            }
            node.setEnd();
        }

        public boolean startsWith(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char curLetter = word.charAt(i);
                if (node.containsKey(curLetter)) {
                    node = node.get(curLetter);
                } else {
                    return false;
                }
            }
            return node!=null;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {

            int length = word.length();
            TrieNode node = root;
            for(int i=0; i<length; i++) {
                char curr = word.charAt(i);
                if(!node.containsKey(curr)) {
                    return false;
                }
                node = node.get(curr);
            }
            return node.isEnd();

        }
    }
    public static List<String> findWords(char[][] board, String[] words) {

        Trie trie = new Trie();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0 ; i< words.length; i++) {
            trie.insert(words[i]);
        }
        Set<String> presentWords = new HashSet<>();
        for(int i =0; i< board.length; i++) {
            for(int j = 0; j< board[0].length; j++) {
                dfs(board, i, j, visited, trie, presentWords, "");
            }
        }

        return new ArrayList<>(presentWords);
    }

    public static void dfs(char[][] board, int i, int j, boolean[][] visited, Trie trie, Set<String> present, String s) {

        if( i < 0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j] )
            return;
        char ch = board[i][j];
        s+=board[i][j];

        if (!trie.startsWith(s)) return;
        if(trie.search(s)){
            present.add(s);
        }
        visited[i][j] = true;
        dfs(board, i+1, j, visited, trie, present, s);
        dfs(board, i-1, j, visited, trie, present, s);
        dfs(board, i, j+1, visited, trie, present, s);
        dfs(board, i, j-1, visited, trie, present, s);
        visited[i][j] = false;
    }
    public static void main(String[] args) {

        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};


        List<String> res = findWords(board, words);
        return;

    }
}
