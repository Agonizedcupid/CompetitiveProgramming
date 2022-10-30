package com.aariyan.cp;

public class Main {

    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.insertAtFirst(1);
        linkedList.insertAtFirst(2);
        linkedList.insertAfterAnyNode(linkedList.head.next, 5);
        linkedList.insertAtEnd(3);

        System.out.println("Before Delete:");
        linkedList.printLinkedList();
        System.out.println("After Delete:");
        linkedList.deleteNode(1);
        linkedList.printLinkedList();

        System.out.println("After sorting Linked List");
        linkedList.sortLinkedList(linkedList.head);
        linkedList.printLinkedList();

        System.out.println("After searching elements");
        System.out.println(linkedList.isFound(linkedList.head, 7));
    }
}

