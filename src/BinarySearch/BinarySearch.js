/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number} index
 */
const binSearch = (nums, target) => {
  let start = 0;
  let end = nums.length - 1;

  while (start <= end) {
    const mid = Math.floor((start + end) / 2);

    // found
    if (nums[mid] === target) {
      return mid;
    }

    // narrow search window
    if (target > nums[mid]) {
      start = mid + 1;
    } else {
      end = mid - 1;
    }
  }

  return -1;
};

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number} index
 */
const binSearchRec = (nums, target) => {
  const [sp, ep] = [0, nums.length - 1];

  return bsRecHelper(nums, target, sp, ep);
};

const bsRecHelper = (nums, target, sp, ep) => {
  const m = Math.floor((sp + ep) / 2);

  // found
  if (nums[m] === target) return m;
  // not found
  if (sp > ep) return -1;

  // recursion
  if (target > nums[m]) {
    return bsRecHelper(nums, target, m + 1, ep);
  } else {
    return bsRecHelper(nums, target, sp, m - 1);
  }
};

const main = () => {
  const data = [1, 3, 4, 7, 8, 9, 12, 15, 16];
  // const target = 4;
  const target = 16;
  console.log(binSearchRec(data, target)); // 8
};

main();
