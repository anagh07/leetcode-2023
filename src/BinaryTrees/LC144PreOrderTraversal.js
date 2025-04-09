/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal = function (root) {
  const result = [];
  preorderHelper(root, result);
  return result;
};

/**
 * @param {TreeNode} node
 * @param {number[]} result
 * @return {number[]} result
 */
const preorderHelper = (node, numbers) => {
  if (!node) return;

  numbers.push(node.val);
  preorderHelper(node.left, numbers);
  preorderHelper(node.right, numbers);
};

// Definition for a binary tree node.
function TreeNode(val, left, right) {
  this.val = val === undefined ? 0 : val;
  this.left = left === undefined ? null : left;
  this.right = right === undefined ? null : right;
}

const main = () => {
  const node = new TreeNode(1);
  node.right = new TreeNode(2);
  node.right.left = new TreeNode(3);

  const result = preorderTraversal(node);
  console.log(result);
};

main();
