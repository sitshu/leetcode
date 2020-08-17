package com.company.design;

import java.util.Deque;
import java.util.LinkedList;

class HitCounter {
    class Request{
        int seconds;
        int count;
        Request(int s, int c) {
            this.seconds = s;
            this.count = c;
        }
    }
    Deque<Request> deque = new LinkedList<>();
    int window;
    int hits;
    /** Initialize your data structure here. */
    public HitCounter() {
        this.window = 300;
        this.hits = 0;
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        while(!deque.isEmpty() && timestamp - deque.peek().seconds>299){
            hits-=deque.peek().count;
            deque.poll();
        }
        if(!deque.isEmpty() && deque.peekLast().seconds == timestamp){
            Request r = deque.peekLast();
            r.count++;
            hits++;
        } else {
            Request request = new Request(timestamp, 1);
            deque.addLast(request);
            hits++;
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!deque.isEmpty() && timestamp - deque.peek().seconds >299){
            hits-=deque.peek().count;
            deque.poll();
        }
        return hits;
    }
}