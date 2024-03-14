/**
 *
 * @param {character[]} letters
 * @param {character} target
 * @return {character}
 */
const nextGreatestLetter = (letters, target) => {
  let sp = 0;
  let ep = letters.length - 1;

  while (sp <= ep) {
    let mid = Math.trunc((sp + ep) / 2);

    if (target < letters[mid]) {
      ep = mid - 1;
    } else {
      sp = mid + 1;
    }
  }

  return letters[sp] ? letters[sp] : letters[0];
};

console.log(nextGreatestLetter(['c', 'f', 'j'], 'a'));
console.log(nextGreatestLetter(['c', 'f', 'j'], 'f'));
