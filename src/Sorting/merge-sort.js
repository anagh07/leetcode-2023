const mergeSort = (nums) => {
  return msHelper(nums);
};

/**
 * @param{number[]} nums
 * @param{number[]} result
 */
const msHelper = (nums) => {
  if (nums.length <= 1) return nums;

  const mid = Math.floor(nums.length / 2);

  // split into two
  const left = msHelper(nums.slice(0, mid));
  const right = msHelper(nums.slice(mid, nums.length));

  // merge
  const lengthRes = left.length + right.length;
  const result = Array(lengthRes);
  let [pLeft, pRight, pCurr] = [0, 0, 0];
  while (pCurr < lengthRes) {
    if (!left[pLeft]) {
      result[pCurr] = right[pRight];
      pCurr++;
      pRight++;
    } else if (!right[pRight]) {
      result[pCurr] = left[pLeft];
      pCurr++;
      pLeft++;
    } else if (left[pLeft] <= right[pRight]) {
      result[pCurr] = left[pLeft];
      pCurr++;
      pLeft++;
    } else {
      result[pCurr] = right[pRight];
      pCurr++;
      pRight++;
    }
  }
  return result;
};

const main = () => {
  const data = [8, 3, 4, 12, 5, 6];
  // const data = [];
  console.log(mergeSort(data));
};

main();
