/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function (nums, target) {
  let sp = 0;
  let ep = nums.length - 1;
  const sol = [-1, -1];

  // Search first occurance
  while (sp <= ep) {
    let mid = Math.trunc((sp + ep) / 2);

    if (target < nums[mid]) {
      ep = mid - 1;
    } else if (target > nums[mid]) {
      sp = mid + 1;
    } else {
      // Possible solution
      sol[0] = mid;
      ep = mid - 1;
    }
  }
  // if first occurance not found dont search again
  if (sol[0] === -1) {
    return sol;
  }

  // Search last occurance
  (sp = 0), (ep = nums.length - 1);
  while (sp <= ep) {
    let mid = Math.trunc((sp + ep) / 2);

    if (target < nums[mid]) {
      ep = mid - 1;
    } else if (target > nums[mid]) {
      sp = mid + 1;
    } else {
      // Possible solution
      sol[1] = mid;
      sp = mid + 1;
    }
  }

  return sol;
};

console.log(searchRange([5, 7, 7, 8, 8, 10], 8));
