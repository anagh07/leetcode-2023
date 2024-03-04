/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
  let robbed = recursion();
  return robbed(nums);
};

// < O(2^n)
let calculations = 0;
function recursion() {
  let cache = {};
  return (rec = (nums, i = 0) => {
    if (cache[i]) {
      return cache[i];
    } else {
      calculations++;
      if (i >= nums.length - 1) {
        return nums[i] ? nums[i] : 0;
      }
      cache[i] = Math.max(rec(nums, i + 1), nums[i] + rec(nums, i + 2));
      return cache[i];
    }
  });
}

// O(2^n)
function slowRec(nums, i = 0) {
  calculations++;
  if (i >= nums.length - 1) {
    return nums[i] ? nums[i] : 0;
  }
  return Math.max(nums[i] + slowRec(nums, i + 2), slowRec(nums, i + 1));
}

// O(n)
// Memoization - bottom up approach
function dpRobber(nums) {
  let cache = []; // max length will be length of nums
  if (nums.length < 2) return nums[0] ? nums[0] : 0;

  // prefill cache with intial data
  cache[0] = nums[0];
  cache[1] = Math.max(nums[0], nums[1]);

  // [ elem1, elem2, elem3]
  // [ cache1, cache2, elem3+cache1 OR cache2]
  for (let i = 2; i < nums.length; i++) {
    calculations++;
    cache[i] = Math.max(nums[i] + cache[i - 2], cache[i - 1]);
  }

  return cache[nums.length - 1];
}

console.log(
  `DP-Rec# Robbed: $${rob([2, 7, 9, 3, 1])}, Calculation steps: ${calculations}`
);
calculations = 0;
console.log(
  `Rec# Robbed: $${slowRec([2, 7, 9, 3, 1])}, Calculation steps: ${calculations}`
);
calculations = 0;
console.log(
  `DP-Norec# Robbed: $${dpRobber([2, 7, 9, 3, 1])}, Calculation steps: ${calculations}`
);
calculations = 0;
console.log(
  `DP-Norec# Robbed: $${dpRobber([
    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
  ])}, Calculation steps: ${calculations}`
);
// console.log(rob([2, 7]));
// console.log(rob([2]));
// console.log(rob([]));
