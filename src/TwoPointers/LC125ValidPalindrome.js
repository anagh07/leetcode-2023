/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function (s) {
  let filtered = '';

  for (let letter of s) {
    if (
      (letter.toLowerCase().charCodeAt(0) >= 97 &&
        letter.toLowerCase().charCodeAt(0) <= 122) ||
      (letter.toLowerCase().charCodeAt(0) >= 48 &&
        letter.toLowerCase().charCodeAt(0) <= 57)
    ) {
      filtered += letter.toLowerCase();
    }
  }

  let i = 0;
  let k = filtered.length - 1;
  while (i < k) {
    if (filtered[i] !== filtered[k]) return false;
    i++;
    k--;
  }
  return true;
};

console.log(isPalindrome('A man, a plan, a canal: Panama'));
console.log(isPalindrome('0P'));
