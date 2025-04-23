/**
 *  Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function (root) {
  const result = [];
  const queue = [root];

  if (!root) {
    return result;
  }

  // iterate every level
  while (queue.length > 0) {
    const levelSize = queue.length;
    const level = [];

    // iterate elements on each level
    for (let i = 0; i < levelSize; i++) {
      // add element to level array
      const curr = queue.shift();
      level.push(curr.val);

      // add next children to queue
      if (curr.left) {
        queue.push(curr.left);
      }
      if (curr.right) {
        queue.push(curr.right);
      }
    }

    result.push(level);
  }

  return result;
};

function TreeNode(val, left, right) {
  this.val = val === undefined ? 0 : val;
  this.left = left === undefined ? null : left;
  this.right = right === undefined ? null : right;
}
