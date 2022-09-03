public class Reverse_linkedlist {
    /*
        ----------------------------------              -----------------------------------
       |   value   |   ref. of next node  |   ----->    |   value   |   ref. of next node |  ---->> NULL
        ----------------------------------              -----------------------------------

        Reverse Means :

                ----------------------------------              -----------------------------------
     NULL <<--- |   value   |   ref. of next node  |   <<---   |   value   |   ref. of next node |
                ----------------------------------              -----------------------------------
     */

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        // Putting the value on Linked List
        //1,2,3,4,5
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);


        // Creating the conenctions between the node:
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;

        //printing the Linked List:
//        while (head != null) {
//            System.out.print(head.value + " ");
//            head = head.next;
//        }
//        System.out.println();

        //Now reversing the Linked List:
//        if (head == null) {
//            return;
//        }
        Node previousNode = null, currentNode = head, nextNode = head.next;
        while (currentNode != null) {
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            if (nextNode != null)
                nextNode = nextNode.next;
        }

        while (previousNode != null) {
            System.out.print(previousNode.value + " ");
            previousNode = previousNode.next;
        }
        System.out.println();
    }
}
