package Convert_Binary_To_Decimal;

public class ConvertBinaryToDecimal {


    static class ListNode {
        ListNode next;
        int value;

        ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(0);
        ListNode third = new ListNode(1);

        head.next = second;
        second.next = third;
        System.out.println(convertIntoInteger(head));

        //Simulation:
        // 1*2^0 + 0*2^1 + 1*2^2 = 1 + 0 + 4 = 5
        // [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]

        ListNode previousNode = null, currentNode = head, nextNode = head.next;

        int power = 0;
        int decimal = 0;
//        while (head != null) {
//            decimal += head.value * Math.pow(2.0, power);
//            power++;
//            head = head.next;
//        }

        while (currentNode != null) {
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            if (nextNode != null) nextNode = nextNode.next;
        }

        while (previousNode != null) {
            decimal += previousNode.value * Math.pow(2.0, power);
            power++;
            previousNode = previousNode.next;
        }

        System.out.println(decimal);
    }

    private static int convertIntoInteger(ListNode head) {

        int answer = 0;
        while (head != null) {
            answer *= 2;
            answer += head.value;
            head = head.next;
        }
        return answer;
    }
}
