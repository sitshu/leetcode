package com.company.amazon;

import java.util.*;

public class SecretCodes {


    public static void main(String[] args)
    {
        int arr[] = { 2, 4, 6, 8, 10 };
        ArrayList<String> alist=new ArrayList<String>();
        alist.add("orange");


        ArrayList<String> blist=new ArrayList<String>();
        blist.add("apple");
        blist.add("apple");

        ArrayList<String> dlist=new ArrayList<String>();
        dlist.add("banana");
        dlist.add("orange");
        dlist.add("apple");

        ArrayList<String> elist=new ArrayList<String>();
        elist.add("banana");



        ArrayList<String> clist=new ArrayList<String>();
        clist.add("orange");
        clist.add("apple");
        clist.add("apple");
        clist.add("banana");
        clist.add("orange");
        clist.add("apple");
        clist.add("banana");

        List<List<String>> codeList = new ArrayList<>();
        codeList.add(alist);
        codeList.add(blist);
        codeList.add(dlist);
        codeList.add(elist);


        int n = arr.length;
        System.out.println(checkWinner(codeList, clist));
    }
    public static int checkWinner(List<List<String>> codeList,
                           List<String> shoppingCart)
    {
        // WRITE YOUR CODE HERE
        Queue<String> secretCodeQueue = new LinkedList<>();
        Queue<String> matchedCodeQueue = new LinkedList<>();
        boolean  comparisonLoop = false;
        for(List<String> codes: codeList){
            for(String code: codes){
                secretCodeQueue.add(code);
            }
            secretCodeQueue.add("@");
        }

        while(!secretCodeQueue.isEmpty()) {
            for(String s: shoppingCart) {
                String code = secretCodeQueue.peek();
                if("@".equalsIgnoreCase(code)){
                    secretCodeQueue.remove();
                    while(!matchedCodeQueue.isEmpty()) {
                        matchedCodeQueue.remove();

                    }

                }
                code = secretCodeQueue.peek();
                if(!code.equalsIgnoreCase(s) && !"anything".equalsIgnoreCase(code)){
                    if(comparisonLoop) {
                        while(!secretCodeQueue.isEmpty()) {
                            matchedCodeQueue.add(secretCodeQueue.remove());
                        }
                        Queue temp = secretCodeQueue;
                        secretCodeQueue = matchedCodeQueue;
                        matchedCodeQueue = temp;
                    }
                    comparisonLoop = false;
                    continue;
                }
                comparisonLoop = true;
                matchedCodeQueue.add(secretCodeQueue.remove());

            }
            secretCodeQueue.remove();
            if(!secretCodeQueue.isEmpty())
                return 0;

        }
        return secretCodeQueue.isEmpty()? 1: 0;



    }
}
