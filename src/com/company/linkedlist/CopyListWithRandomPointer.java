package com.company.linkedlist;

public class CopyListWithRandomPointer {

    public  static class Node {
        int val;
        Node next;
        Node random;
        Node(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        //[[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node first = new Node(7);
        Node second = new Node(13);
        Node third = new Node(11);
        Node fourth = new Node(10);
        Node fifth = new Node(1);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        second.random = first;
        third.random = fifth;
        fourth.random = third;
        fifth.random = first;

        Node head = copyRandomList(first);
        return;

    }

    public static Node copyRandomList(Node head) {

        Node curr = head;

        while (curr != null) {
            Node newNode = new Node(curr.val);
            Node next = curr.next;
            newNode.next = next;
            curr.next = newNode;

            curr = next;
        }
        curr = head;

        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        curr = head;
        Node newHead = new Node(-1);
        Node newCurr = newHead;
        while (curr != null && curr.next != null) {
            newCurr.next = curr.next;
            newCurr = newCurr.next;
            curr.next = curr.next.next;
            curr = curr.next;


        }

        return newHead.next;
    }

}
