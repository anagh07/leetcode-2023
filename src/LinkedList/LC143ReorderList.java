package LinkedList;

public class LC143ReorderList {

    public void reorderList(ListNode head) {
        /*
        APPROACH
        - split into two from the middle
        - reverse the second list
        - merge the two lists
         */
        if (head == null || head.next == null) return;
        ListNode first = head;
        ListNode second = head;
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        // create first half, break tail
        second = first.next;
        first.next = null;

        // reverse second list
        ListNode current = second;
        ListNode previous = null, next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        // merge two lists
        second = previous;
        first = head;
        ListNode nextFirst, nextSecond;
        while (first != null && second != null) {
            nextFirst = first.next;
            first.next = second;
            nextSecond = second.next;
            second.next = nextFirst;

            // move both up
            first = nextFirst;
            second = nextSecond;
        }
    }

    public static class ListNode {
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
