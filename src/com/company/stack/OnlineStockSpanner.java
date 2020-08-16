package com.company.stack;


import java.util.Stack;

public class OnlineStockSpanner {
    class Pair {
        int i;
        int y;
        Pair(int i, int y){
            this.i = i;
            this.y = y;
        }

        public int getKey(){
            return this.i;
        }
        public int getValue() {
            return this.y;
        }
    }
    class StockSpanner {
        Stack<Pair> stack;
        public StockSpanner() {
            stack = new Stack<>();
        }

        public int next(int price) {
            int count = 1;
            while(!stack.isEmpty() && stack.peek().getKey() <= price){
                count+=stack.pop().getValue();
            }
            stack.push(new Pair(price, count));
            return count;
        }
    }

}
