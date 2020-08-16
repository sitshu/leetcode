package com.company.dp;

import java.util.*;

public class DistanceKFromTarget {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
       TreeNode two = new TreeNode(5);
       TreeNode three = new TreeNode(1);
       TreeNode four = new TreeNode(6);
       TreeNode five = new TreeNode(2);
       TreeNode six = new TreeNode(0);
       TreeNode seven = new TreeNode(8);
       TreeNode eight = new TreeNode(7);
       TreeNode nine = new TreeNode(4);


       root.left = two;
       root.right =three;
        two.left = four;
        two.right = five;
       three.left = six;
       three.right = seven;
       five.left = eight;
       five.right = nine;
        List<Integer>res = distanceK(root, two,5);
    }


    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();

        buildMap(root, null, map);

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(target);
        int dist = 0;
        List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<TreeNode>();
        while(!queue.isEmpty()){
            int size = queue.size();
            if(dist == K) {
                for(int i=0; i<size; i++){
                    result.add(queue.poll().val);
                }
                return result;
            }
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                for(TreeNode neighbor: map.get(node)){
                    if(!visited.contains(neighbor)){
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            if(dist == K )
                return result;
            dist++;
        }

        return result;
    }

    static void  buildMap(TreeNode root, TreeNode parent, Map<TreeNode, List<TreeNode>> map) {

        if(root == null)
            return;
        if(!map.containsKey(root)){
            map.put(root, new ArrayList<>());
            if(parent!=null){
                map.get(root).add(parent);
                map.get(parent).add(root);
            }
            buildMap(root.left, root, map);
            buildMap(root.right, root, map);
        }
    }
}
