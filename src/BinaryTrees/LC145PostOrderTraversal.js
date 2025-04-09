/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var postorderTraversal = function (root) {
  const result = [];
  postorderHelper(root, result);
  return result;
};

/**
 * @param {TreeNode} node
 * @param {number[]} result
 * @return {number[]} result
 */
const postorderHelper = (node, numbers) => {
  if (!node) return;

  postorderHelper(node.left, numbers);
  postorderHelper(node.right, numbers);
  numbers.push(node.val);
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

  const result = postorderTraversal(node);
  console.log(result);
};

main();
