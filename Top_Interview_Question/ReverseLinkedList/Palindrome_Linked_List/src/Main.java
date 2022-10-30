public class Main {

    public static void main(String[] args) {
        //[1,2,2,1]

        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(2);
        ListNode fourth = new ListNode(2);

        head.next = second;
        second.next = third;
        third.next = fourth;

        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {

        ListNode fastPointer = head, slowPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        //SlowPointer will be in the mid:
        assert slowPointer != null;
        ListNode reverseInMid = reverseFromMid(slowPointer);
        ListNode reversedList = reverseInMid;
        ListNode traverseFromStart = head;

        while (reversedList != null) {
            if (traverseFromStart.value != reversedList.value) return false;
            traverseFromStart = traverseFromStart.next;
            reversedList = reversedList.next;
        }
        assert reverseInMid != null;
        reverseFromMid(reverseInMid);
        return true;
    }

    public static ListNode reverseFromMid(ListNode head) {
        ListNode previousNode = null, currentNode = head, nextNode = head.next;
        while (currentNode != null) {
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            if (nextNode != null) {
                nextNode = nextNode.next;
            }
        }

        return previousNode;
    }

}

class ListNode {

    int value;
    ListNode next;
    public ListNode(int value) {
        this.value = value;
        next = null;
    }
}