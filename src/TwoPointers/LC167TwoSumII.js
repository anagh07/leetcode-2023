/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (numbers, target) {
  let i = 0;
  let k = numbers.length - 1;

  while (i < k) {
    let sum = numbers[i] + numbers[k];
    if (sum === target) return [i + 1, k + 1];
    if (sum < target) {
      i++;
    } else {
      k--;
    }
  }
  return [i + 1, k + 1];
};

console.log(twoSum([2, 7, 11, 15], 9));
console.log(twoSum([2, 3, 4], 6));
console.log(twoSum([5, 25, 75], 100));
