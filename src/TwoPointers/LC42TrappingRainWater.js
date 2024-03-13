/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function (height) {
  let i, k, leftMax, rightMax, water;
  i = water = 0;
  k = height.length - 1;
  leftMax = height[i];
  rightMax = height[k];

  while (i < k) {
    if (leftMax < rightMax) {
      i++;
      leftMax = Math.max(leftMax, height[i]);
      water += leftMax - height[i];
    } else {
      k--;
      rightMax = Math.max(rightMax, height[k]);
      water += rightMax - height[k];
    }
  }
  return water;
};

console.log(trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]));
