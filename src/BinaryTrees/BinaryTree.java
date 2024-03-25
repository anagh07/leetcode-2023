package BinaryTrees;

import java.util.ArrayList;
import java.util.Scanner;

public class BinaryTree {

    private Node root;

    public BinaryTree() {

    }

    public void populate(Scanner scanner) {
        System.out.print("Enter root.value: ");
        int rootValue = scanner.nextInt();
        this.root = new Node(rootValue);
        populate(scanner, this.root);
    }

    private void populate(Scanner scanner, Node currNode) {
        // Try to insert to left
        System.out.print(String.format("Enter left child of %d? (true/false): ", currNode.value));
        boolean checkLeft = scanner.nextBoolean();
        if (checkLeft) {
            System.out.print("Enter left child value: ");
            int value = scanner.nextInt();
            currNode.left = new Node(value);
            populate(scanner, currNode.left);
        }

        // Try to insert to right
        System.out.print(String.format("Enter right child %d? (true/false): ", currNode.value));
        boolean checkRight = scanner.nextBoolean();
        if (checkRight) {
            System.out.print("Enter right child value: ");
            int value = scanner.nextInt();
            currNode.right = new Node(value);
            populate(scanner, currNode.right);
        }
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

    private static class Node {

        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        binaryTree.populate(scanner);
        binaryTree.display();
        binaryTree.prettyDisplay();
    }
}
