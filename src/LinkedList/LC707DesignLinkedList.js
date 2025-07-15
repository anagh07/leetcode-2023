/**
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:
    MyLinkedList() Initializes the MyLinkedList object.
    int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
    void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
    void addAtTail(int val) Append a node of value val as the last element of the linked list.
    void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list,
      the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
    void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.

Example 1:
    Input
    ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
    [[], [1], [3], [1, 2], [1], [1], [1]]
    Output
    [null, null, null, null, 2, null, 3]
*/
class MyLinkedList {
  head;
  tail;
  length;

  constructor() {
    this.head = new ListNode();
    this.tail = new ListNode();
    this.head.nextNode = this.tail;
    this.tail.prevNode = this.head;
    this.length = 0;
  }

  /**
   * @param {number} index
   * @return {number}
   */
  get(index) {
    if (index >= this.length) return -1;
    let currentNode = this.head;
    for (let i = 0; i <= index; i++) {
      currentNode = currentNode.nextNode;
    }
    return currentNode.value;
  }

  /**
   * @param {number} val
   * @return {void}
   */
  addAtHead(val) {
    const newNode = new ListNode(val);
    const currFirstNode = this.head.nextNode;

    newNode.nextNode = currFirstNode;
    currFirstNode.prevNode = newNode;
    this.head.nextNode = newNode;
    this.length++;
  }

  /**
   * @param {number} val
   * @return {void}
   */
  addAtTail(val) {
    const newNode = new ListNode(val);
    const currLastNode = this.tail.prevNode;

    newNode.prevNode = currLastNode;
    currLastNode.nextNode = newNode;
    this.tail.prevNode = newNode;
    this.length++;
  }

  /**
   * @param {number} index
   * @param {number} val
   * @return {void}
   */
  addAtIndex(index, val) {
    if (index > this.length) return;
    if (index === this.length) {
      this.addAtTail(val);
      return;
    }
    if (index === 0) {
      this.addAtHead(val);
      return;
    }

    // traverse to index
    let currNode = this.head;
    for (let i = 0; i <= index && currNode !== null; i++) {
      currNode = currNode.nextNode;
    }
    const prevNode = currNode.prevNode;

    // create new node
    const newNode = new ListNode(val);

    // update the links
    prevNode.nextNode = newNode;
    newNode.prevNode = prevNode;
    newNode.nextNode = currNode;
    currNode.prevNode = newNode;
    this.length++;
  }

  /**
   * @param {number} index
   * @return {void}
   */
  deleteAtIndex(index) {
    if (index >= this.length || index < 0) return;

    // first node = last node = to remove
    if (this.length === 1) {
      this.head.nextNode = this.tail;
      this.tail.prevNode = this.head;
      this.length--;
      return;
    }

    // first node
    if (index === 0) {
      const toBeRemoved = this.head.nextNode;
      const newFirstNode = toBeRemoved.nextNode;
      this.head.nextNode = newFirstNode;
      newFirstNode.prevNode = null;
      toBeRemoved.nextNode = null;
      this.length--;
      return;
    }

    // last node
    if (index === this.length - 1) {
      const toBeRemoved = this.tail.prevNode;
      const newLastNode = toBeRemoved.prevNode;
      this.tail.prevNode = newLastNode;
      newLastNode.nextNode = null;
      toBeRemoved.prevNode = null;
      this.length--;
      return;
    }

    // not last or first
    let currNode = this.head;
    for (let i = 0; i <= index; i++) {
      currNode = currNode.nextNode;
    }
    const newPrev = currNode.prevNode;
    const newNext = currNode.nextNode;
    newPrev.nextNode = newNext;
    newNext.prevNode = newPrev;
    currNode.nextNode = null;
    currNode.prevNode = null;
    this.length--;
  }

  /**
   * @param {}
   * @return {number[]} values
   */
  getAll() {
    const values = [];
    let currNode = this.head;
    for (let i = 0; i < this.length; i++) {
      currNode = currNode.nextNode;
      values.push(currNode.value);
    }
    return values;
  }
}

class ListNode {
  #value;
  #nextNode;
  #prevNode;

  constructor(value = -1, nextNode = null, prevNode = null) {
    this.#value = value;
    this.#nextNode = nextNode;
    this.#prevNode = prevNode;
  }

  get value() {
    return this.#value;
  }

  set value(value) {
    this.#value = value;
  }

  get nextNode() {
    return this.#nextNode;
  }

  set nextNode(node) {
    this.#nextNode = node;
  }

  get prevNode() {
    return this.#prevNode;
  }

  set prevNode(node) {
    this.#prevNode = node;
  }

  hasNext() {
    return !!this.#nextNode;
  }

  hasPrev() {
    return !!this.#prevNode;
  }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = new MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(val)
 * obj.addAtTail(val)
 * obj.addAtIndex(index,val)
 * obj.deleteAtIndex(index)
 */

// const main = () => {
//   const myLinkedList = new MyLinkedList();
//   myLinkedList.addAtHead(1);
//   myLinkedList.addAtTail(3);
//   myLinkedList.addAtTail(6);
//   console.log(myLinkedList.getAll());
//   myLinkedList.addAtIndex(1, 7);
//   console.log(myLinkedList.getAll());
//   myLinkedList.addAtIndex(9, 7);
//   myLinkedList.addAtIndex(3, 9);
//   console.log(myLinkedList.getAll());
//   myLinkedList.addAtIndex(0, 0);
//   console.log(myLinkedList.getAll());

//   // delete
//   myLinkedList.deleteAtIndex(0);
//   console.log(myLinkedList.getAll());
//   myLinkedList.deleteAtIndex(2);
//   console.log(myLinkedList.getAll());
//   myLinkedList.deleteAtIndex(3);
//   console.log(myLinkedList.getAll());
//   myLinkedList.deleteAtIndex(9);
//   console.log(myLinkedList.getAll());
// };

const main = () => {
  // ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
  // [[], [1], [3], [1, 2], [1], [1], [1]]
  const myLL = new MyLinkedList();
  myLL.addAtHead(1);
  console.log(myLL.getAll());
  myLL.addAtTail(3);
  console.log(myLL.getAll());
  myLL.addAtIndex(1, 2);
  console.log(myLL.getAll());
  console.log(myLL.get(1));
  myLL.deleteAtIndex(1);
  console.log(myLL.getAll());
  console.log(myLL.get(1));
  console.log(myLL.getAll());
};

main();
