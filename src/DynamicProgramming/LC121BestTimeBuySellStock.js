/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
    let l = 0,
        r = 1,
        max = 0;

    while (r < prices.length) {
        if (prices[l] > prices[r]) {
            l = r;
        } else {
            max = Math.max(max, prices[r] - prices[l]);
        }
        r++;
    }

    return max;
};

function dpMaxProfit(prices) {
    let min = prices[0];
    let max = 0;

    for (let i = 1; i < prices.length; i++) {
        max = Math.max(max, prices[i] - min);
        min = Math.min(min, prices[i]);
    }
    return max;
}

console.log(maxProfit([7, 1, 5, 3, 6, 4]));
console.log(dpMaxProfit([7, 1, 5, 3, 6, 4]));
