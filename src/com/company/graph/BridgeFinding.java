package com.company.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeFinding {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(0); a.add((1));
        List<Integer> b = new ArrayList<>();
        b.add(1); b.add(2);
        List<Integer> c = new ArrayList<>();
        c.add(2); c.add(0);
        List<Integer> d = new ArrayList<>();
        d.add(1); d.add(3);
        List<List<Integer>> input = new ArrayList<>();
        input.add(a);input.add(b);input.add(c); input.add(d);
        criticalConnections(4, input);
    }
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        int[] timestamp = new int[n];
        int timer = 0;
        boolean[] visited = new boolean[n];
        List<List<Integer>> critical = new ArrayList<>();
        for(int i=0; i<n; i++)
            graph[i] = new ArrayList<>();
        for(List<Integer> edge: connections){

            graph[edge.get(0)].add(edge.get(1));
            graph[edge.get(1)].add(edge.get(0));

        }
        criticalConnectionsUtil(graph, 0, -1, timestamp, critical, timer, visited);
        return critical;

    }

    public static void criticalConnectionsUtil(List<Integer>[] graph, int node, int parent, int[] timeStamp, List<List<Integer>> result, int timer, boolean[] visited) {
        visited[node] = true;
        timeStamp[node] = timer++;
        int currentTimestamp = timeStamp[node];
        for(Integer neighbor: graph[node]) {
            if(neighbor== parent) continue;
            if(!visited[neighbor])
                criticalConnectionsUtil(graph, neighbor, node, timeStamp, result, timer, visited);
            timeStamp[node] = Math.min(timeStamp[node], timeStamp[neighbor]);
            if(currentTimestamp<timeStamp[neighbor]) result.add(Arrays.asList(node, neighbor));

        }
    }
}
