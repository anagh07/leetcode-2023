/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function (lists) {
};

var helper = function (lists) {
  // escape conditions
  if (lists.length === 1) {
    return lists[0];
  } else if (lists.length === 2) {
    return mergeTwoLists(lists[0], lists[1]);
  }

  // recursive call
};

var mergeTwoLists = function (list1, list2) {
  let node1 = list1;
  let node2 = list2;
  let curr = new ListNode(0);
  let result = null;
  let count = 0;

  while (node1 || node2) {
    if (!node1) {
      curr.next = node2;
      node2 = node2.next;
    } else if (!node2) {
      curr.next = node1;
      node1 = node1.next;
    } else if (node1.val <= node2.val) {
      curr.next = node1;
      node1 = node1.next;
    } else {
      curr.next = node2;
      node2 = node2.next;
    }
    // store head in result
    if (count == 0) result = curr.next;
    count++;
    curr = curr.next;
  }

  return result;
};
