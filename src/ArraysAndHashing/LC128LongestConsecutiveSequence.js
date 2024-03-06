/**
 * @param {number[]} nums
 * @return {number}
 */
var longestConsecutive = function (nums) {
  // Only the numbers that does not have a left neighbor in the number line are the beginning of sequences
  let sequenceLengthMax = 0;
  let currentLength;
  const numsSet = new Set(nums);
  for (let num of nums) {
    if (!numsSet.has(num - 1)) {
      currentLength = 1;
      for (let i = num; numsSet.has(i + 1); i++) {
        currentLength++;
      }
      sequenceLengthMax = Math.max(currentLength, sequenceLengthMax);
    }
  }
  return sequenceLengthMax;
};

console.log(longestConsecutive([100, 4, 200, 1, 3, 2]));
