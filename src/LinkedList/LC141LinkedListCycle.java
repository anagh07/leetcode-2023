package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LC141LinkedListCycle {

    // HashMap solution
    public boolean hasCycle(ListNode head) {
        // Time complexity O(n), space complexity O(n)
        Map<ListNode, Boolean> hash = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            if (hash.containsKey(cur.next)) return true;
            hash.put(cur, true);
            cur = cur.next;
        }
        return false;
    }

    // Fast-slow pointer solution
    public boolean hasCycle2(ListNode head) {
        // Time complexity O(n), space complexity O(1)
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (fastPointer == slowPointer) return true;
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
