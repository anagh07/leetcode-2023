/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
    const hashed = {};
    let value;

    for (let index = 0; index < nums.length; index++) {
        value = nums[index];
        if (target - value in hashed) {
            return [hashed[target - value], index];
        }
        hashed[value] = index;
    }
};

console.log(twoSum([2, 7, 11, 15], 9));
