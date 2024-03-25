package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    private Node root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(int[] nums) {
        this.populate(nums);
    }

    public int height(Node node) {
        if (node == null) return -1;
        return node.height;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            return new Node(value);
        }

        if (value <= node.getValue()) {
            node.left = insert(value, node.left);
        } else {
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    public void populate(int[] nums) {
        for (int num : nums) {
            this.insert(num);
        }
    }

    public void populateSorted(int[] numbers) {
        populateSorted(numbers, 0, numbers.length - 1);
    }

    private void populateSorted(int[] numbers, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        this.insert(numbers[mid]);
        populateSorted(numbers, start, mid);
        populateSorted(numbers, mid + 1, end);
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    public void display() {
        display(root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        // Print current node
        System.out.println(indent + node.value);
        // Left sub-tree
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
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
            System.out.println("|---->" + node.value);

        } else {
            System.out.println(node.value);
        }

        prettyDisplay(node.left, level + 1);
    }

    public ArrayList<Integer> preOrder() {
        ArrayList<Integer> nodeList = new ArrayList<>();
        return preOrder(nodeList, root);
    }

    private ArrayList<Integer> preOrder(ArrayList<Integer> nodeList, Node node) {
        if (node == null) return nodeList;
        nodeList.add(node.value);
        preOrder(nodeList, node.left);
        preOrder(nodeList, node.right);
        return nodeList;
    }

    public ArrayList<Integer> inOrder() {
        ArrayList<Integer> nodeList = new ArrayList<>();
        return inOrder(nodeList, root);
    }

    private ArrayList<Integer> inOrder(ArrayList<Integer> nodeList, Node node) {
        if (node == null) return nodeList;
        inOrder(nodeList, node.left);
        nodeList.add(node.value);
        inOrder(nodeList, node.right);
        return nodeList;
    }

    public ArrayList<Integer> postOrder() {
        ArrayList<Integer> nodeList = new ArrayList<>();
        return postOrder(nodeList, root);
    }

    private ArrayList<Integer> postOrder(ArrayList<Integer> nodeList, Node node) {
        if (node == null) return nodeList;
        postOrder(nodeList, node.left);
        postOrder(nodeList, node.right);
        nodeList.add(node.value);
        return nodeList;
    }

    public static void main(String[] args) {
        BinarySearchTree BST = new BinarySearchTree();
        BST.populate(new int[]{15, 10, 12, 6, 21, 19, 23});
        BST.display();
        BST.prettyDisplay();
        System.out.println("BST.isEmpty(): " + BST.isEmpty());
        System.out.println("BST.isBalanced(): " + BST.isBalanced());

        BinarySearchTree bst2 = new BinarySearchTree(new int[]{1, 2, 3, 7, 5});
        bst2.display();
        bst2.prettyDisplay();
        System.out.println("bst2.isEmpty(): " + bst2.isEmpty());
        System.out.println("bst2.isBalanced(): " + bst2.isBalanced());

        // Use sorted array to populated
        BinarySearchTree bstSorted = new BinarySearchTree();
        bstSorted.populateSorted(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        bstSorted.prettyDisplay();
        System.out.println("bstSorted.isBalanced(): " + bstSorted.isBalanced());
        System.out.println("Pre-order: " + bstSorted.preOrder().toString());
        System.out.println("In-order: " + bstSorted.inOrder().toString());
        System.out.println("Post-order: " + bstSorted.postOrder().toString());
    }
}
