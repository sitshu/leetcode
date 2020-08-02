package com.company.amazon;

import java.util.*;

public class MergeItemAssociations {




    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args) {

        String[][] categories = {{"Item1", "Item2"} ,{"Item5", "Item3"},
                {"Item3", "Item4"},
                {"Item4", "Item5"}};
        List<String> result = getCatagories(categories);


    }

    public static List<String> getCatagories(String[][] categories) {
        Graph graph = new Graph();

        for(String[] category: categories) {
            graph.addEdge(category[0], category[1]);
        }

        int maxlength = 0;
        List<String> result = new ArrayList<>();
        for(String vertex: graph.getVertices()) {
            List<String> depth = dfs(vertex, graph, new HashSet<>(), new ArrayList<>());
            if(maxlength< depth.size()) {
                result = depth;
                maxlength = depth.size();
            }
        }

        return result;

    }

    private static List<String> dfs(String vertex, Graph graph, Set<String> visited, List<String> depth) {

        if( visited.contains(vertex))
            return depth;

        visited.add(vertex);
        depth.add(vertex);
        List<String> edges = graph.get(vertex);
        if(edges == null)
            return depth;
        for(String edge: edges){
            dfs(edge, graph, visited, depth);
        }
        //recursion.remove(vertex);
        return depth;
    }

    static class Graph {

        Map<String, List<String>> graph =new HashMap<>() ;


        public int size() {
            return graph.size();
        }

        public Set<String> getVertices() {
            return graph.keySet();
        }

        public void addVertex(String s) {
            graph.put(s, new ArrayList<String>());
        }

        public void addEdge(String s, String d) {
            List<String> edges = graph.getOrDefault(s, new ArrayList<>());
            edges.add(d);
            graph.put(s, edges);
        }

        public List<String> get(String s) {
            return graph.get(s);
        }

    }
}
