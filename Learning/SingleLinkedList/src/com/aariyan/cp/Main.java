package com.aariyan.cp;

public class Main {

    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.insertAtFirst(1);
        linkedList.insertAtFirst(2);
        linkedList.insertAfterAnyNode(linkedList.head.next,5);
        linkedList.insertAtEnd(3);

        linkedList.printLinkedList();
    }
}

