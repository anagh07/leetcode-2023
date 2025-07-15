class TreeNode {
  constructor(val = -1, left = null, right = null) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  addLeft(node) {
    this.left = node;
  }

  addRight(node) {
    this.right = node;
  }
}

const main = () => {
  const node = new TreeNode(5);
  console.log(`${node.val} ${node.left} ${node.right}`);
};

main();
