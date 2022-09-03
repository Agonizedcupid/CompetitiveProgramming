package traverse;


/**
 * Time Complexity:
 *                  O(N)
 */

public class TraverseLinkedList {

    //This class represent the Whole Linked List Structure:
    /*
        ----------------------------------              -----------------------------------
       |   value   |   ref. of next node  |   ----->    |   value   |   ref. of next node |
        ----------------------------------              -----------------------------------
     */
    static class Node {
        int value; //value that would be added & will come from as insertion:
        Node next; // This means the reference of next node

        Node(int value) { // Constructor to initialize the value:
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        TraverseLinkedList linkedList = new TraverseLinkedList();

        //Just creating few linked list and set the value but we didn't create any reference yet:
        // Means we have to point the node to understand which node will be before or after which node:
        Node head = new Node(100);
        Node second = new Node(200);
        Node third = new Node(300);
        Node fourth = new Node(400);

        // Creating the pointer or reference to each node:
        head.next = second;
        second.next = third;
        third.next = fourth;


        //Now print the Linked List:
        //creating the Node to traverse all:
        Node traverse = head; // it means we will start traversing from head:
        while (traverse != null) {
            System.out.println(traverse.value);
            traverse = traverse.next;
        }
    }
}
