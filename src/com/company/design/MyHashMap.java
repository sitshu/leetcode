package com.company.design;

import java.util.LinkedList;
import java.util.List;

class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}


class MyHashMap {
    int hashkey;
    List<Bucket> hashspace;
    class Bucket {
        List<Pair<Integer, Integer>> values;
        Bucket() {
            this.values = new LinkedList<>();
        }

        public Integer get(Integer key){
            for(Pair<Integer, Integer> pair: values){
                if(pair.first == key){
                    return pair.second;
                }
            }
            return -1;
        }

        public void update(Integer key,  Integer value){
            boolean found = false;

            for(Pair<Integer, Integer> pair: values){
                if(pair.first == key){
                    pair.second = value;
                    found = true;
                }
            }

            if(!found){
                Pair<Integer,Integer> pair = new Pair(key, value);
                this.values.add(pair);
            }
        }

        public void remove(Integer key){
            boolean found = false;

            for(Pair<Integer, Integer> pair: values){
                if(pair.first == key){
                    this.values.remove(pair);
                    break;
                }
            }
        }
    }
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.hashkey = 2069;
        this.hashspace = new LinkedList<>();
        for (int i = 0; i < this.hashkey; ++i) {
            this.hashspace.add(new Bucket());
        }

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashed = key % hashkey;
        this.hashspace.get(hashed).update(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashed = key % hashkey;
        return this.hashspace.get(hashed).get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashed = key % hashkey;
        this.hashspace.get(hashed).remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */