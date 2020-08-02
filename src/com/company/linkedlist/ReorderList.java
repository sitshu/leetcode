package com.company.linkedlist;

public class ReorderList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void reorderList(ListNode head) {

        ListNode fastpointer = head.next;
        ListNode slowpointer = head;

        while(fastpointer != null && fastpointer.next!=null) {

            slowpointer = slowpointer.next;
            fastpointer = fastpointer.next.next;
        }


        ListNode reverseHead = slowpointer.next;
        slowpointer.next = null;
        ListNode curr = reverseHead;
        ListNode prev = null, next = null;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode list1 = head;
        ListNode list2 = prev;
        ListNode dummyNode = new ListNode(0);
        ListNode mergeList = dummyNode;
        dummyNode.next = list1;
        boolean takeList1 = true;
        while(list1!=null && list2!=null) {

            if(takeList1 == true){
                mergeList.next = list1;
                list1 = list1.next;
                mergeList = mergeList.next;
                takeList1 = false;
            } else {
                mergeList.next = list2;
                list2 = list2.next;
                takeList1=true;
                mergeList = mergeList.next;
            }
        }

        if(list2!=null)
            mergeList.next = list2;
        else if(list1 != null)
            mergeList.next = list1;



        return;

    }

    public static void main(String[] args) {

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode (5);

        one.next =two;
        two.next = three;
        three.next = four;
        four.next = five;

        reorderList(one);
        return;

    }
}
