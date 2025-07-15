/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function (root) {
  const numbers = [];
  inOrderHelper(numbers, root);
  return numbers;
};

const inOrderHelper = (numbers, root) => {
  if (!root) return;

  inOrderHelper(numbers, root.left);
  numbers.push(root.val);
  inOrderHelper(numbers, root.right);
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

  const result = inorderTraversal(node);
  console.log(result);
};

main();
