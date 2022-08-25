package com.aariyan.cp;

public class Main {
    //Creating the Node for the data and Next Reference:
    /*

    _____________    (next)       ---------------   (next)     -----------------
    |  1(data)  |    ------>      |   2(data)   |   ------>    |    30(data)   |
    -------------                 ---------------              -----------------

     */

    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        Node second = new Node(50);
        Node third = new Node(100);

        head.next = second;
        second.next = third;

        while (head != null) {
            System.out.println(head.data+"");
            head = head.next;
        }
    }
}

