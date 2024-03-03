/**
 * @param {number} n
 * @return {number}
 */
var fib = function (n) {
  let fastFib = dynamicProgFib();
  return fastFib(n);
};

// RECURSIVE SOLUTION
let slowerCalculations = 0;
function recursion(num) {
  slowerCalculations++;
  if (num < 2) {
    return num;
  } else {
    return recursion(num - 1) + recursion(num - 2);
  }
}

// DYNAMIC PROGRAMMING SOLUTION
let calculations = 0;
function dynamicProgFib() {
  let cache = {};
  return rec = (num) => {
    if (cache[num]) {
      return cache[num];
    } else {
      calculations++;
      if (num < 2) {
        return num;
      } else {
        cache[num] = rec(num - 1) + rec(num - 2);
        return cache[num];
      }
    }
  }
}

console.log(`Recursion:\tfib(20) = ${recursion(20)}, with ${slowerCalculations} calculations`);
console.log(`Dynamic Prog:\tfib(20) = ${fib(20)}, with ${calculations} calculations`);
