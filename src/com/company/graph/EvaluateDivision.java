//package com.company.graph;
//
//import javafx.util.Pair;
//
//import java.util.*;
//
//public class EvaluateDivision {
//
//    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        Map<String, List<Pair<String,Double>>> map = new HashMap<>();
//        double[] result = new double[queries.size()];
//        Set<String> set = new HashSet<>();
//        for(int i=0; i<equations.size(); i++) {
//            List<String> edge = equations.get(i);
//            double weight = values[i];
//            List<Pair<String, Double>> edges = map.getOrDefault(edge.get(0), new ArrayList<>());
//            edges.add(new Pair<String, Double>(edge.get(1), weight));
//            List<Pair<String,Double>> reverseEdges = map.getOrDefault(edge.get(1), new ArrayList<>());
//            reverseEdges.add(new Pair<String, Double>(edge.get(0), 1/weight));
//            set.add(edge.get(0));
//            set.add(edge.get(1));
//            map.put(edge.get(0), edges);
//            map.put(edge.get(1), reverseEdges);
//        }
//        int i =0;
//        for(List<String> path: queries){
//            String source = path.get(0);
//            String dest = path.get(1);
//            if(!set.contains(source) || !set.contains(dest))
//                result[i++] = -1.0;
//            else
//                result[i++] = dfs(map, path.get(0), path.get(1), 1.0, new HashSet<>());
//        }
//
//        return result;
//    }
//
//    double dfs( Map<String, List<Pair<String,Double>>> map, String current, String dest, double cost, Set<String> visited){
//
//        if(current.equals(dest))
//            return cost;
//        visited.add(current);
//        List<Pair<String, Double>> edges = map.get(current);
//
//        for(Pair<String, Double> edge: edges){
//            if(!visited.contains(edge.getKey())){
//                double weight = dfs(map, edge.getKey(), dest, cost*edge.getValue(), visited);
//                if(weight!= -1.0)
//                    return weight;
//            }
//        }
//
//        return -1.0;
//
//    }
//}
