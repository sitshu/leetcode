package com.company.amazon;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ScoreOfOrderedHits {

    public int totalScore(int num, List<String> blocks) {
        Stack<Integer> stack = new Stack<>();
        int total = 0;
        for (String str : blocks) {
            switch (str) {
                case "Z":
                    if (stack.size() > 0) {
                        int z = stack.pop();
                        total -= z;
                    }

                    break;
                case "X":
                    if (stack.size() > 0) {
                        int x = stack.peek();
                        total += (x * 2);
                        stack.push(x * 2);
                    }
                    break;
                case "+":
                    if (stack.size() > 1) {
                        int a = stack.pop();
                        int b = stack.pop();
                        total += a + b;
                        stack.push(b);
                        stack.push(a);
                        stack.push(a + b);
                    }
                    break;
                default:
                    stack.push(Integer.parseInt(str));
                    total += Integer.parseInt(str);
                    break;
            }
        }
        return total;
    }

}
