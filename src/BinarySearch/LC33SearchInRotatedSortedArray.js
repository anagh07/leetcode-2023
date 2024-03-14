/**
 * @param {number[]} nums
 * @param {number} target
 * @return {boolean}
 */
var search = function (nums, target) {
  let pivot = -1;
  let sp = 0;
  let ep = nums.length - 1;

  // Find pivot
  while (sp <= ep) {
    let mid = Math.trunc((sp + ep) / 2);

    if (mid < ep && nums[mid] > nums[mid + 1]) {
      pivot = mid;
      break;
    } else if (mid > sp && nums[mid] < nums[mid - 1]) {
      pivot = mid - 1;
      break;
    } else if (nums[mid] > nums[0]) {
      sp = mid + 1;
    } else {
      ep = mid - 1;
    }
  }
  if (pivot === -1) pivot = ep;

  // Search in sub-arrays
  if (nums[pivot] === target) {
    return pivot;
  }
  (sp = 0), (ep = pivot);
  while (sp <= ep) {
    let mid = Math.trunc((sp + ep) / 2);

    if (target < nums[mid]) {
      ep = mid - 1;
    } else if (target > nums[mid]) {
      sp = mid + 1;
    } else {
      return mid;
    }
  }
  (sp = pivot + 1), (ep = nums.length - 1);
  while (sp <= ep) {
    let mid = Math.trunc((sp + ep) / 2);

    if (target < nums[mid]) {
      ep = mid - 1;
    } else if (target > nums[mid]) {
      sp = mid + 1;
    } else {
      return mid;
    }
  }

  return -1;
};

console.log(search([2, 5, 6, 0, 0, 1, 2], 3));
console.log(search([2, 5, 6, 0, 0, 1, 2], 0));
console.log(search([1, 0, 1, 1, 1], 0));
console.log(search([1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1], 2));
console.log(search([1, 3, 5], 0));
