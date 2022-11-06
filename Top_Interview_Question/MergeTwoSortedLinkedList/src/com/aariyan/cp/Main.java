package com.aariyan.cp;

public class Main {

    public static void main(String[] args) {
        LinkedList firstList = new LinkedList();
        firstList.addNode(1);
        firstList.addNode(3);
        firstList.addNode(5);
        firstList.addNode(10);
        System.out.println("First List");
        firstList.printNode();

        //second list:
        LinkedList secondList = new LinkedList();
        secondList.addNode(1);
        secondList.addNode(2);
        secondList.addNode(6);
        secondList.addNode(11);
        System.out.println("Second List");
        secondList.printNode();


        //Merged two sorted list:
        LinkedList mergedLinkedList = new LinkedList();
        mergedLinkedList.mergeTwoSortedList(firstList.head, secondList.head);
        System.out.println("Merged List");
        mergedLinkedList.printNode();
    }
}
