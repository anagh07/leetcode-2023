/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function (head) {
  if (!head) return null;

  let prev = null;
  let curr = head;
  let currNext = curr.next ? curr.next : null;

  while (curr) {
    // reverse link
    curr.next = prev;

    // move one node forward
    prev = curr;
    curr = currNext;
    currNext = currNext ? currNext.next : null;
  }

  return prev;
};

function ListNode(val, next) {
  this.val = val === undefined ? 0 : val;
  this.next = next === undefined ? null : next;
}
