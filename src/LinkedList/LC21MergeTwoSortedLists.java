package LinkedList;

public class LC21MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode previous = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                previous.next = list1;
                previous = list1;
                list1 = list1.next;
            } else {
                previous.next = list2;
                previous = list2;
                list2 = list2.next;
            }
        }
        previous.next = list1 != null ? list1 : list2;
        return head.next;
    }

    // Definition for singly-linked list.
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
