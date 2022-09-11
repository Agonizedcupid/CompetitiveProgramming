package ReverseLinkedList;

import java.util.List;

public class ReverseLinkedList {


    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        //Printing the linked list:
//        while (head != null) {
//            System.out.println(head.value);
//            head = head.next;
//        }

        //Reversing a linked list:
        ListNode previousNode = null, currentNode = head, nextNode = head.next;

        while (currentNode != null) {
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            if (nextNode != null) nextNode = nextNode.next;
        }

        while (previousNode != null) {
            System.out.println(previousNode.value + " ");
            previousNode = previousNode.next;
        }
    }
}
