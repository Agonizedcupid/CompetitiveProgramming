package DeleteLinkedList;

import java.util.Collection;
import java.util.Collections;

public class DeleteLinkedList {

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
        Node first = new Node(2);
        Node second = new Node(3); //Want to delete this Node:
        Node third = new Node(4);

        Node temp = head;
        temp.next = first;
        first.next = second;
        second.next = third;

        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();

        //delete the second node:
        //Making the second node as head or beginning:
        Node beg = second;
        beg.next = third;
        while (beg != null) {
            System.out.print(beg.value+" ");
            beg = beg.next;
        }
        System.out.println();


        //Swapping the second node & third node:
        Node tempNode = second;
        second = third;
        third = tempNode;
        second.next = third;
        third.next = null;

        while (second != null) {
            System.out.print(second.value + " " );
            second = second.next;
        }
        System.out.println();
    }
}
