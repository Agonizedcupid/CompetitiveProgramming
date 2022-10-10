package Add_Two_Numbers;

public class TwoLinkedList {

    static class FirstNode {
        int value;
        FirstNode next;

        FirstNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    static class SecondNode {
        int value;
        SecondNode next;

        SecondNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        //Putting value to both Linked List:

        FirstNode firstListHead = new FirstNode(2);
        FirstNode firstListSecond = new FirstNode(4);
        FirstNode firstListThird = new FirstNode(3);
        // creating connections of first LinkedList:
        firstListHead.next = firstListSecond;
        firstListSecond.next = firstListThird;


        //For the Second Linked List:
        SecondNode secondListHead = new SecondNode(5);
        SecondNode secondListSecond = new SecondNode(6);
        SecondNode secondListThird = new SecondNode(4);
        //Creating the connections:
        secondListHead.next = secondListSecond;
        secondListSecond.next = secondListThird;

        int countFirstLinkedList = 0;
        StringBuilder firstDigit = new StringBuilder();
        //Now printing First Linked List:
        while (firstListHead != null) {
            countFirstLinkedList++;
            System.out.print(firstListHead.value + " ");
            firstDigit.append(firstListHead.value);
            firstListHead = firstListHead.next;
        }
        System.out.println();

        int countSecondLinkedList = 0;
        StringBuilder secondDigit = new StringBuilder();
        //Printing the second Linked List:
        while (secondListHead != null) {
            countSecondLinkedList++;
            System.out.print(secondListHead.value + " ");
            secondDigit.append(secondListHead.value);
            secondListHead = secondListHead.next;
        }
        System.out.println();

        int sum = Integer.parseInt(firstDigit.toString()) + Integer.parseInt(secondDigit.toString());
        int result = 0;
        while (sum > 0) {
            int remainder = sum % 10;
            result = result * 10 + remainder;
            sum /= 10;
        }

        System.out.println(result);

    }

}
