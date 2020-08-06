package com.company.amazon;

public class PrisonCellAfterNDays {

    public static  void main(String[] args) {
        // [0,1,0,1,1,0,0,1]
        //7
        int [] arr = {0,1,0,1,1,0,0,1};
        int[] cell = prisonAfterNDays(arr, 7);
    }
    public static int[] prisonAfterNDays(int[] cells, int N) {

        boolean[] cellsCopy = new boolean[cells.length];
        boolean[] state = new boolean[cells.length];
        for(int i=0; i<cells.length; i++) {
            cellsCopy[i] = cells[i] == 0? false: true;
        }
        for(int i=0; i<cells.length; i++)
            state[i] = cellsCopy[i];
        while(N-->0) {

            state[0] = false;
            state[cells.length-1] = false;

            for(int i = 1; i<cells.length-1; i++){
                state[i] = !(cellsCopy[i-1]^cellsCopy[i+1]);
            }

            for(int i = 0; i<cells.length; i++){
                cellsCopy[i] = state[i];
            }
        }
        for(int i = 0; i<cells.length; i++){
            cells[i] =    cellsCopy[i] ==false? 0 : 1;
        }

        return cells;

    }
 }
