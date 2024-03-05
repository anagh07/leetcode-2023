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
    return (recursion = (num) => {
        if (cache[num]) {
            return cache[num];
        } else {
            calculations++;
            if (num < 2) {
                return num;
            } else {
                cache[num] = recursion(num - 1) + recursion(num - 2);
                return cache[num];
            }
        }
    });
}

// DP without REC
function dpNoRec(num) {
    if (num <= 2) return num === 0 ? 0 : 1;

    let cache = [0, 1];
    for (let i = 2; i <= num; i++) {
        calculations++;
        cache[i] = cache[i - 1] + cache[i - 2];
    }
    return cache[num];
}

console.log(
    `Recursion:\tfib(20) = ${recursion(20)}, with ${slowerCalculations} calculations`
);
console.log(`Dynamic Prog:\tfib(20) = ${fib(20)}, with ${calculations} calculations`);
calculations = 0;
console.log(
    `Dynamic Prog2:\tfib(20) = ${dpNoRec(20)}, with ${calculations} calculations`
);
