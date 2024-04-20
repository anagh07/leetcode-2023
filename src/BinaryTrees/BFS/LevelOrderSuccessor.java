package BinaryTrees.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree and a node in the binary tree, find Levelorder
 * successor of the given node. That is, the node that appears after
 * the given node in the level order traversal of the tree.
 * <p>
 * Note: The task is not just to print the data of the node, you have
 * to return the complete node from the tree.
 */

// https://www.geeksforgeeks.org/level-order-successor-of-a-node-in-binary-tree/

public class LevelOrderSuccessor {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left,
                 TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode findSuccessor(TreeNode root, TreeNode taget) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

                // If target == current then return next node in queue
                if (currentNode == taget) {
                    return queue.peek();
                }
            }
        }
        return null;
    }

}
