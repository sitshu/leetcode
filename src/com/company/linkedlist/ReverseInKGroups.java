package com.company.linkedlist;

public class ReverseInKGroups {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head;
        int count = 0;
        while (count<k && ptr!=null) {
            ptr=ptr.next;
            count++;
        }
        if(count<k)
            return head;
        ListNode newHead = reverseList(head, k);
        head.next = reverseKGroup(ptr, k);
        return newHead;
    }

    ListNode reverseList(ListNode head, int K){

        ListNode ptr = head;
        ListNode prev=null, next=null;
        while(K-- >0){
            next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
        }
        return prev;
    }
}
