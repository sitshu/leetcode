package com.company;

import java.util.HashMap;
import java.util.PriorityQueue;

class FreqStack {

    public static void main(String[] args){

        FreqStack stack = new FreqStack();
        stack.push(4);
        stack.push(0);
        stack.push(9);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        int w = stack.pop();
        stack.push(6);
        int x = stack.pop();
        stack.push(1);
        int y = stack.pop();
        stack.push(1);
        int z = stack.pop();
        stack.push(4);
        int a = stack.pop();
        int b = stack.pop();
        int c = stack.pop();
        int d = stack.pop();
        int e = stack.pop();
        int f = stack.pop();




    }
    HashMap<Integer, Integer> map;
    PriorityQueue<Node> queue;
    int size;
    class Node{
        int value;
        int frequency;
        int index;

        Node(int val, int freq, int i){
            this.value = val;
            this.frequency = freq;
            this.index = i;
        }
    }
    public FreqStack() {
        map = new HashMap<>();
        queue = new PriorityQueue<>((n1, n2) -> n1.frequency!=n2.frequency? n2.frequency-n1.frequency: n2.index-n1.index);
        size = 0;
    }

    public void push(int x) {

        map.put(x, map.getOrDefault(x, 0)+1);
        queue.add(new Node(x, map.get(x), size));
        size++;
    }

    public int pop() {
        Node node = queue.poll();
        int freq = map.get(node.value);
        if(freq == 1){
            map.remove(node.value);
            return node.value;
        }
        map.put(node.value, --freq);
        return node.value;
    }
}

