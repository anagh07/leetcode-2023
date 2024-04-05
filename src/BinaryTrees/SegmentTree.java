package BinaryTrees;

public class SegmentTree {

    public static void main(String[] args) {
        SegmentTree tree = new SegmentTree(new int[]{
                3, 8, 7, 6, -2, -8, 4, 9
        });
        tree.display();
        tree.prettyDisplay();
    }

    class Node {
        int value;
        int leftInterval;
        int rightInterval;
        Node left;
        Node right;

        public Node(int leftInterval, int rightInterval) {
            this.leftInterval = leftInterval;
            this.rightInterval = rightInterval;
        }

        public Node(int leftInterval, int rightInterval, int value) {
            this(leftInterval, rightInterval);
            this.value = value;
        }
    }

    Node root;

    public SegmentTree(int[] arr) {
        root = this.constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            // leaf node
            return new Node(start, start, arr[start]);
        }

        int mid = (start + end) / 2;
        Node newNode = new Node(start, end);

        newNode.left = constructTree(arr, start, mid);
        newNode.right = constructTree(arr, mid + 1, end);

        newNode.value = newNode.left.value + newNode.right.value;
        return newNode;
    }

    public void display() {
        display(root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        // Print current node
        System.out.println(indent + node.value + "(" + node.leftInterval + "," + node.rightInterval + ")");
        // Left subtree
        display(node.left, indent + "\t\t");
        display(node.right, indent + "\t\t");
    }

    public void prettyDisplay() {
        System.out.println("\n");
        prettyDisplay(root, 0);
        System.out.println("\n");
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) return;

        prettyDisplay(node.right, level + 1);

        if (level > 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------>" + node.value + "(" + node.leftInterval + "," + node.rightInterval + ")");

        } else {
            System.out.println(node.value + "(" + node.leftInterval + "," + node.rightInterval + ")");
        }

        prettyDisplay(node.left, level + 1);
    }
}
