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

    //Deleting a node:
    public void deleteNode(int position) {

        //if the head is null means no value:
        if (head == null) {
            return; //Nothing to delete:
        }
        ListNode toDeleteNode = head;
        if (position == 0) {
            head = toDeleteNode.next;
            return;
        }
        for (int i = 0; i < position - 1 && toDeleteNode != null; i++) {
            toDeleteNode = toDeleteNode.next;
        }

        //Position is not found:
        if (toDeleteNode == null || toDeleteNode.next == null) {
            return;
        }

        //if found then remove the node:
        ListNode removeFromMemory = toDeleteNode.next;
        toDeleteNode.next = removeFromMemory.next;
        removeFromMemory = null;

    }

    public boolean isFound(ListNode head, int valueToFind) {
        ListNode currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == valueToFind) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void sortLinkedList(ListNode head) {
        ListNode currentNode = head;
        ListNode nextNode = null;
        if (head == null) {
            return;
        }
        while (currentNode != null) {
            nextNode = currentNode.next;
            while (nextNode != null) {
                if (currentNode.value > nextNode.value) {
                    int carry = currentNode.value;
                    currentNode.value = nextNode.value;
                    nextNode.value = carry;
                }
                nextNode = nextNode.next;
            }
            currentNode = currentNode.next;
        }
    }

    public void printLinkedList() {
        ListNode printList = head;
        while (printList != null) {
            System.out.print(printList.value + " ");
            printList = printList.next;
        }
        System.out.println();
    }
}
