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

/**
 * 
 * @param {string} s 
 * @param {string} t 
 * @returns {boolean}
 */
let isAnagramOptimized = (s, t) => {
    let count = Array(26).fill(0)

    if (s.length !== t.length) {
        return false;
    }

    for (let i = 0; i < s.length; i++) {
        // console.log(count[s.charCodeAt(i) - 'a'.charCodeAt(0)]);
        count[s.charCodeAt(i) - 'a'.charCodeAt(0)]++;
        count[t.charCodeAt(i) - 'a'.charCodeAt(0)]--;
    }

    for (let num of count) {
        if (num !== 0) {
            return false;
        }
    }

    return true;
}

// Using basic solution
console.log(isAnagram('anagram', 'nagaram'));
console.log(isAnagram('rat', 'car'));

// Using optimized solution
console.log(isAnagramOptimized('anagram', 'nagaram'));
console.log(isAnagramOptimized('rat', 'car'));