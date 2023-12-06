package LinkedList;

public class LC206ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode nextNode = head == null ? null : head.next;
        ListNode previousNode = null;

        while (current != null) {
            // reverse the link
            current.next = previousNode;

            previousNode = current;
            current = nextNode;
            nextNode = nextNode != null ? nextNode.next : null;
        }

        return previousNode;
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
