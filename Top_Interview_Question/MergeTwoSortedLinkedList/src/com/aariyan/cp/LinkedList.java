package com.aariyan.cp;

import java.util.List;

public class LinkedList {
    ListNode head;

    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    //Inserting data:
    public void addNode(int value) {
        if (head == null) {
            head = new ListNode(value);
            return;
        }

        ListNode newNode = new ListNode(value);
        newNode.next = null;

        ListNode carry = head;
        while (carry.next != null) {
            carry = carry.next;
        }

        carry.next = newNode;
    }

    //Printing data:
    public void printNode() {
        ListNode printNode = head;
        while (printNode != null) {
            System.out.print(printNode.value + " ");
            printNode = printNode.next;
        }
        System.out.println();
    }

    //Merging Two List:
    public void mergeTwoSortedList(ListNode firstList, ListNode secondList) {
        ListNode returnList = new ListNode(0);
        ListNode traverse = returnList;

        ListNode firstHead = firstList;
        ListNode secondHead = secondList;

        while (true) {
            //if no value in first list
            if (firstHead == null) {
                traverse.next = secondHead;
                break;
            }

            // if no value in second list
            if (secondHead == null) {
                traverse.next = firstHead;
                break;
            }

            // if has the value:
            if (firstHead.value >= secondHead.value) {
                traverse.next = secondHead;
                secondHead = secondHead.next;
            } else {
                traverse.next = firstHead;
                firstHead = firstHead.next;
            }

            traverse = traverse.next;
        }
        head = returnList.next;
    }
}
