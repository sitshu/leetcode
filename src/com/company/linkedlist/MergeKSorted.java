package com.company.linkedlist;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MergeKSorted {

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(lists.length, Comparator.comparingInt(a -> a.val));
        ListNode head = new ListNode(-2);
        ListNode curr = head;
        for(int i=0; i<lists.length; i++) {
            priorityQueue.add(lists[i]);
        }

        while(!priorityQueue.isEmpty()) {


                ListNode node = priorityQueue.poll();
                curr.next = node;
                curr = node;
           if(curr.next!= null)
                priorityQueue.add(curr.next);
        }

        return head.next;
    }
}
