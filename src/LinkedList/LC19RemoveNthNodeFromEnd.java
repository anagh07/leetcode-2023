package LinkedList;

public class LC19RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode previous = null;
        int listLength = 0;

        while (current != null) {
            listLength++;
            current = current.next;
        }

        int indexFromStart = listLength + 1 - n;
        current = head;

        for (int i = 1; i < indexFromStart; i++) {
            previous = current;
            current = current.next;
        }

        if (previous == null) return head.next;
        previous.next = current.next == null ? null : current.next;
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}
