/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function (tokens) {
  const stack = [];
  let num1, num2, res;

  for (let token of tokens) {
    switch (token) {
      case '+':
        res = stack.pop() + stack.pop();
        stack.push(res);
        break;
      case '-':
        num1 = stack.pop();
        num2 = stack.pop();
        res = num2 - num1;
        stack.push(res);
        break;
      case '*':
        res = stack.pop() * stack.pop();
        stack.push(res);
        break;
      case '/':
        num1 = stack.pop();
        num2 = stack.pop();
        res = Math.trunc(num2 / num1);
        stack.push(res);
        break;
      default:
        stack.push(parseInt(token));
    }
  }
  return stack.pop();
};

console.log(evalRPN(['2', '1', '+', '3', '*']));
console.log(
  evalRPN(['10', '6', '9', '3', '+', '-11', '*', '/', '*', '17', '+', '5', '+'])
);
