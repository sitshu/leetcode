package com.company.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class minMeetingRooms {
    public static void main(String[] args) {

        int [][]a = {
                {2,15},{36,45}, {9,29}, {16,23}, {16,23},{4,9}
        };
        int min = minMeetingRooms(a);
        return;
    }


    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        if(intervals.length ==0)
            return 0;
        int high = intervals[0][1];

        int count = 1;

        for(int i=1; i< intervals.length; i++) {

            if(intervals[i][0] < high){
                count++;
                high = Math.min(high, intervals[i][1]);
            } else {
                high = intervals[i][1];
            }
        }
        return count;
    }
}
