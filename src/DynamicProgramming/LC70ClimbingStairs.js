/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function (n) {
    const climb = recStairs();
    return climb(n);
};

// NON-RECURSIVE
function dpClimb(n) {
    let cache = [1, 2];

    for (let i = 2; i <= n; i++) {
        cache[i] = cache[i - 1] + cache[i - 2];
    }

    return cache[n - 1];
}
console.log(dpClimb(5));

// RECURSIVE DP
function recStairs() {
    let cache = { 1: 1, 2: 2 };
    return (rec = (n) => {
        if (cache[n]) return cache[n];

        cache[n] = rec(n - 1) + rec(n - 2);
        return cache[n];
    });
}
console.log(climbStairs(4));
