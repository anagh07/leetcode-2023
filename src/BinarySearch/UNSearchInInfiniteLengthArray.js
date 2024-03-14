/**
 *
 * @param {number[]} nums
 * @param {number} target
 * @returns {number}
 */
const searchInfinitedArray = (nums, target) => {
  let sp = 0;
  let ep = 1;
  let chunkSize = 1;

  // Find the window where number lies
  while (target > nums[ep]) {
    sp = ep + 1;
    chunkSize *= 2;
    ep = sp + chunkSize;
  }

  // Binary search in window
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

console.log(searchInfinitedArray([2, 3, 5, 6, 8, 9, 11, 15, 17, 18, 21, 27, 29, 31], 18));
