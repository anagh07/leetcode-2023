var fibGenerator = function* () {
  let last = 1;
  let secondLast = 0;

  while (true) {
    yield secondLast;
    let next = last + secondLast;
    secondLast = last;
    last = next;
  }
};

const myfun = fibGenerator();
for (let i = 0; i < 11; i++) {
  console.log(myfun.next().value);
}
