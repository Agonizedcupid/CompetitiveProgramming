package com.aariyan.cp;

public class SingleLinkedList {
    ListNode head;

    class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    //Insert at the beginning:
    public void insertAtFirst(int value) {
        ListNode newHead = new ListNode(value);
        newHead.next = head;
        head = newHead;
    }

    //Inserting after any node:
    public void insertAfterAnyNode(ListNode currentNode, int value) {
        if (currentNode == null) {
            System.out.println("Current Node Can't be null!");
            return;
        }

        ListNode newInsertedNode = new ListNode(value);
        newInsertedNode.next = currentNode.next;
        currentNode.next = newInsertedNode;
    }

    //Insert at the end:
    public void insertAtEnd(int value) {
        if (head == null) {
            head = new ListNode(value);
            return;
        }

        ListNode lastNode = new ListNode(value);
        lastNode.next = null;

        //Creating a carry node:
        ListNode carry = head;
        while (carry.next != null) {
            carry = carry.next;
        }
        carry.next = lastNode;
        return;
    }

    public void printLinkedList() {
        ListNode printList = head;
        while (printList != null) {
            System.out.print(printList.value + " ");
            printList = printList.next;
        }
    }
}
