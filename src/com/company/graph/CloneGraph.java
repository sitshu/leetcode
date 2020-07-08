package com.company.graph;

import java.util.*;

public class CloneGraph {
    public static Node cloneGraph(Node node) {

            Node headNode = new Node(node.val);
        Map<Node, Node>  nodeMap = new HashMap<>();
        nodeMap.put(node, headNode);
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(node);
        while(!nodeQueue.isEmpty()) {
            Node currentNode = nodeQueue.remove();
            Node currentNodeCopy = nodeMap.get(currentNode);
            if(currentNode.neighbors!=null) {
                List<Node> neighbors = currentNode.neighbors;
                List<Node> neighborsCopy = new ArrayList<>();
                for(Node neighbor: neighbors) {
                    Node neighborCopy = null;
                    if(nodeMap.containsKey(neighbor)){
                        neighborCopy = nodeMap.get(neighbor);
                    } else {
                        neighborCopy = new Node(neighbor.val);
                        nodeMap.put(neighbor, neighborCopy);
                        nodeQueue.add(neighbor);
                    }
                    neighborsCopy.add(neighborCopy);
                }
                currentNodeCopy.neighbors = neighborsCopy;
            }
        }
        return headNode;

    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
       // [[2,4],[1,3],[2,4],[1,3]]
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node.neighbors.add(node2);
        node.neighbors.add(node4);
        node2.neighbors.add(node);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node);
        node4.neighbors.add(node3);

        Node nodecopy = cloneGraph(node);
        return;

    }
}
