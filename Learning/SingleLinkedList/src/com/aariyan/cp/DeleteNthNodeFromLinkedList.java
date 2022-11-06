package com.aariyan.cp;

public class DeleteNthNodeFromLinkedList {
    public static void main (String[] args) {
        //INPUT: 1
//        SingleLinkedList linkedList = new SingleLinkedList();
//        linkedList.insertAtFirst(1);
//        linkedList.insertAtFirst(2);
//        linkedList.insertAfterAnyNode(linkedList.head.next, 5);
//        linkedList.insertAtEnd(3);
//        linkedList.deleteNthNode(1);
//        linkedList.printLinkedList();


        //INPUT: 2
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.insertAtFirst(3);
        linkedList.insertAtFirst(2);
        linkedList.insertAtFirst(1);
        linkedList.printLinkedList();
        linkedList.deleteNthNode(2);
        linkedList.printLinkedList();
    }
}
