package BinaryTrees.BFS;

import java.util.*;


public class LC103ZigagLevelOrderTraversal {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelNumber = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();

                if (levelNumber % 2 == 0) {
                    // reverse order
                    level.add(0, currNode.val);
                } else {
                    // regular order
                    level.add(currNode.val);
                }

                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            result.add(level);
            levelNumber++;
        }
        return result;
    }

    // Instead of adding to start of level array,
    // remove in reverse oder from queue
    public List<List<Integer>> betterZigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelNumber = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode;
                if (levelNumber % 2 == 0) {
                    // reverse order
                    currNode = queue.pollLast();

                    if (currNode.right != null) queue.offerFirst(currNode.right);
                    if (currNode.left != null) queue.offerFirst(currNode.left);
                } else {
                    // normal order
                    currNode = queue.pollFirst();

                    if (currNode.left != null) queue.offerLast(currNode.left);
                    if (currNode.right != null) queue.offerLast(currNode.right);
                }
                level.add(currNode.val);
            }
            result.add(level);
            levelNumber++;
        }
        return result;
    }
}
