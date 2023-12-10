package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LC138DeepCopyListWithRandomPointer {

    public static void main(String[] args) {
        Integer[][] data = {{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};
        Node head = new Node(7);
        Node elem1 = new Node(13);
        Node elem2 = new Node(11);
        Node elem3 = new Node(10);
        Node elem4 = new Node(1);
        head.next = elem1;
        elem1.next = elem2;
        elem2.next = elem3;
        elem3.next = elem4;
        elem1.random = head;
        elem2.random = elem4;
        elem3.random = elem2;
        elem4.random = head;
        Node copiedList = copyRandomList(head);
    }

    public static Node copyRandomList(Node head) {
        Node current = head;
        Map<Node, Node> oldNew = new HashMap<>();
        while (current != null) {
            oldNew.put(current, new Node(current.val));
            current = current.next;
        }
        current = head;
        while (current != null) {
            oldNew.get(current).next = oldNew.get(current.next);
            oldNew.get(current).random = oldNew.get(current.random);
            current = current.next;
        }
        return oldNew.get(head);
    }

    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
