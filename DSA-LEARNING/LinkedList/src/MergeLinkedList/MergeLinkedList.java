package MergeLinkedList;

public class MergeLinkedList {

    static class ListNode1 {
        int value;
        ListNode1 listOne;

        ListNode1(int value) {
            this.value = value;
            listOne = null;
        }
    }

    static class ListNode2 {
        int value;
        ListNode2 listTwo;

        ListNode2(int value) {
            this.value = value;
            listTwo = null;
        }
    }

    public static void main(String[] args) {
        //1,2,4
        ListNode1 head1 = new ListNode1(1);
        ListNode1 second1 = new ListNode1(2);
        ListNode1 third1 = new ListNode1(4);

        head1.listOne = second1;
        second1.listOne = third1;

        ListNode1 head2 = new ListNode1(1);
        ListNode1 second2 = new ListNode1(2);
        ListNode1 third2 = new ListNode1(4);

        head2.listOne = second2;
        second2.listOne = third2;

        mergeLinkedList(head1, head2);

    }

    public static void mergeLinkedList(ListNode1 head1, ListNode1 head2) {

        while (head2 != null) {
            System.out.print(head1.value + " ");
            if (head1 != null) {
                head1 = head1.listOne;
            } else {
                head1.listOne = head2;
                head2 = head2.listOne;
            }
        }

    }
}
