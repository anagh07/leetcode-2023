var fibGenerator = function*() {
    let fib = [0, 1, 1];
    // Start fib calc
    // fib(0)
    yield fib[0];

    // fib(1)
    yield fib[1];

    // fib(2)
    yield fib[2];

    while (true) {
        fib.shift();
        fib.push(fib[1] + fib[0]);
        yield fib[2];
    }
}

const myfun = fibGenerator();
console.log(myfun.next().value);
console.log(myfun.next().value);
console.log(myfun.next().value);
console.log(myfun.next().value);
console.log(myfun.next().value);
console.log(myfun.next().value);