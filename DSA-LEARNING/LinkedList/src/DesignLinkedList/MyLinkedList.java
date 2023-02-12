package DesignLinkedList;

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        next = null;
    }
}

public class MyLinkedList {

    ListNode beforeHead; //  why beforeHead? because I'm just adding a dummy node
    // and later on i wll not be using it. It's just initialization purpose
    int size;

    public MyLinkedList() {
        beforeHead = new ListNode(-1);
        size = 0;
    }

    public int get(int index) { // return the value of index, if not found return -1;
        ListNode currentHead = beforeHead;
        if (index <= size) {
            for (int listIndex = 0; listIndex < index; listIndex++) {
                currentHead = currentHead.next;
            }
            return currentHead.value;
        }
        return -1;
    }

    public void addAtHead(int val) { // Adding a new node as head
        ListNode newHead = new ListNode(val);
        //ListNode copyNode = beforeHead; // Just making a copy to make sure that, the original node is not ended up
        newHead.next = beforeHead;
        beforeHead = newHead;
        printListNode(beforeHead);
        // Just increment the size to track the list length:
        size++;
    }

    public void addAtTail(int val) {
        // Adding a new node at very end
        // 1 -> 2 -> 3 -> Null => 1 -> 2 -> 3 -> 4 -> Null
        ListNode currentHead = beforeHead;
        while (currentHead.next != null) {
            currentHead = currentHead.next;
        }
        currentHead.next = new ListNode(val);
        size++;
        printListNode(currentHead);
    }

    public void addAtIndex(int index, int val) { // Add anywhere in the LinkedList
        ListNode currentNode = beforeHead;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index >= size) {
            return;
        }
        ListNode newNode = new ListNode(val);
        for (int listIndex = 0; listIndex < index; listIndex++) {
            currentNode = currentNode.next;
        }
        // 1 -> 2 -> 3 -> Null => 1 -> 0 -> 2 -> 3 -> Null
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        size++;
        printListNode(currentNode);
    }

    public void deleteAtIndex(int index) { // delete a node from anywhere
        if (index > size) {
            return;
        }
        ListNode currentNode = beforeHead;
        for (int listIndex = 0; listIndex < index; listIndex++) {
            // 1 -> 2 -> 3 -> Null => 1 -> 0 -> 2 -> 3 -> Null
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
        size--;
    }

    void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println();
    }
}
