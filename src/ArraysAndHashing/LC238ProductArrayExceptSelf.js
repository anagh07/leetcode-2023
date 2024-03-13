/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function (nums) {
  const prefix = [];
  const postfix = [];
  const sol = [];

  for (let i = 0; i < nums.length; i++) {
    prefix[i] = i === 0 ? 1 : nums[i - 1] * prefix[i - 1];
  }
  for (let i = nums.length - 1; i >= 0; i--) {
    postfix[i] = i === nums.length - 1 ? 1 : nums[i + 1] * postfix[i + 1];
    sol[i] = postfix[i] * prefix[i];
  }
  return sol;
};

console.log(productExceptSelf([-1, 1, 0, -3, 3]));
