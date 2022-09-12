package MiddleOfLinkedList;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

public class MiddleOfLinkedList {

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        //Node sixth = new Node(6);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        //fifth.next = sixth;

        Node carry = head;
//        Node middleNode = findTheMiddle(carry);
//        System.out.println("Middle: " + middleNode.value);

        Node middleNode = findTheMiddleByOnIteration(carry);
        System.out.println("Middle: " + middleNode.value);

        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static Node findTheMiddleByOnIteration(Node carry) {
        Node slowestNode = carry, fastestNode = carry;

        while (fastestNode != null && fastestNode.next != null) {
            fastestNode = fastestNode.next.next; //it means it will skip one node (Speed is double than slowestNode)
            slowestNode = slowestNode.next;
        }
        return slowestNode;
    }

    //Very easy approach:

    /**
     * Time O(n) + O(n) = O(2n) = O(n)
     * Space = Constant Space O(1):
     */
    private static Node findTheMiddle(Node carry) {
        int size = 0;
        Node findMiddle = carry;
        while (carry != null) {
            size++;
            carry = carry.next;
        }
        //System.out.println(size);

        size = size / 2;
        while (size > 0) {
            assert findMiddle != null;
            findMiddle = findMiddle.next;
            size--;
        }
        return findMiddle;
    }
}
