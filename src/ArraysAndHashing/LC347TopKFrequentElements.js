/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function (nums, k) {
  const map = new Map();
  const solution = [];

  for (let num of nums) {
    if (map.has(num)) {
      map.set(num, map.get(num) + 1);
    } else {
      map.set(num, 1);
    }
  }

  const sortedEntries = Array.from(map.entries());
  sortedEntries.sort(([aValue, aCount], [bValue, bCount]) => {
    return bCount - aCount;
  });
//   console.log(sortedEntries);
  for (let i = 0; i < k; i++) {
    solution[i] = sortedEntries[i][0];
  }

  return solution;
};

console.log(topKFrequent([1, 1, 1, 2, 2, 3], 2));
