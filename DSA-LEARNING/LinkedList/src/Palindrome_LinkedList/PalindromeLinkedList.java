package Palindrome_LinkedList;

public class PalindromeLinkedList {

    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(1);
        // ListNode traverseNode = head;
        head.next = second;
        second.next = third;
        third.next = fourth;


        boolean result = isPalindrome(head);
        System.out.println(result);
    }

    private static boolean isPalindrome(ListNode head) {
        return findMid(head);
    }

    private static boolean findMid(ListNode head) {
        ListNode fastNode = head, slowest = head;

        //1 1 2 10
        while (fastNode != null && fastNode.next != null) {
            slowest = slowest.next;
            fastNode = fastNode.next.next;
        }

        assert slowest != null;
        ListNode reverse = reverseList(slowest);
        ListNode mid = reverse, start = head;
        while (mid != null) {
            if (start.value != mid.value) return false;
            mid = mid.next;
            start = start.next;
        }
        assert reverse != null;
        reverseList(reverse);
        return true;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode carry = head;
        ListNode previousNode = null, currentNode = carry, nextNode = carry.next;
        while (currentNode != null) {
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            if (nextNode != null) nextNode = nextNode.next;
        }

        return previousNode;
    }
}
