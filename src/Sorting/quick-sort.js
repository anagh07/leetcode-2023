const quickSort = (numbers) => {
  qsHelper(numbers, 0, numbers.length - 1);
};

const qsHelper = (numbers, start, end) => {
  if (start >= end) return;

  let sp = start;
  let ep = end;
  const p = Math.trunc((sp + ep) / 2);
  const numPivot = numbers[p];

  while (sp <= ep) {
    // move sp till condition violation
    while (numbers[sp] < numPivot) {
      sp++;
    }
    // move ep till condition violation
    while (numbers[ep] > numPivot) {
      ep--;
    }
    // swap
    if (sp <= ep) {
      const temp = numbers[sp];
      numbers[sp] = numbers[ep];
      numbers[ep] = temp;
      sp++;
      ep--;
    }
  }

  // recursively sort two halves
  qsHelper(numbers, start, ep);
  qsHelper(numbers, sp, end);
};

const main = () => {
  const nums = [1, 5, 11, 3, 12, 6];
  quickSort(nums);
  console.log(nums);
};

main();
