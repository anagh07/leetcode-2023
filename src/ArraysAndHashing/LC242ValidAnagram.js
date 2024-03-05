/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function (s, t) {
    if (s.length !== t.length) return false;

    const hashed = {};
    let sChar, tChar;

    for (let index = 0; index < s.length; index++) {
        sChar = s.charAt(index);
        tChar = t.charAt(index);

        hashed[sChar] = hashed[sChar] ? hashed[sChar] + 1 : 1;
        hashed[tChar] = hashed[tChar] ? hashed[tChar] - 1 : -1;
    }
    for (let char in hashed) {
        if (hashed[char] !== 0) return false;
    }

    return true;
};

console.log(isAnagram('anagram', 'nagaram'));
console.log(isAnagram('rat', 'car'));
