package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {

        int last = 0;
        int first =0;
        Map<Character, Integer> counterMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<S.length(); i++){
            Character currentChar = S.charAt(i);
            counterMap.put(currentChar, counterMap.getOrDefault(currentChar, 0) +1);
        }
        Map<Character, Integer> map = new HashMap<>();
        int index =0; int length =S.length();
        int start=0;
        while(index<length){
            Character currentChar = S.charAt(index);
            if(map.containsKey(currentChar)){
                map.put(currentChar, counterMap.get(currentChar)-1);
            };
            if(map.get(currentChar) == 0){
                map.remove(currentChar);
            }
            if(map.size() == 0){
                result.add( index - start +1);
                start = index+1;
                index = index+1;
            }
            index++;
        }
        return result;
    }
}
