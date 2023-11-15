package Stacks;

import java.util.Stack;

public class ReversePolishNotation {
    /*
    NOTES:
        - division between integer truncates towards 0. In java this automatically happens. -1/2 = 0;
     */
    public static void main(String[] args) {
//        String[] tokens = {"2","1","+","3","*"};
//        String[] tokens = {"4","13","5","/","+"};
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int result = evalRPN(tokens);
        System.out.println(result);
    }

    public static int evalRPN(String[] tokens) {

        Stack<Integer> numbers = new Stack<>();

        for (String token : tokens) {

            int result;
            int num1;
            int num2;
            switch (token) {
                case "+":
                    result = numbers.pop() + numbers.pop();
                    numbers.push(result);
                    break;
                case "-":
                    num1 = numbers.pop();
                    result = numbers.pop() - num1;
                    numbers.push(result);
                    break;
                case "*":
                    result = numbers.pop() * numbers.pop();
                    numbers.push(result);
                    break;
                case "/":
                    num1 = numbers.pop();
                    num2 = numbers.pop();
                    result = num2 / num1;
                    numbers.push(result);
                    break;
                default:
                    numbers.push(Integer.parseInt(token));
            }
        }

        return numbers.pop();
    }
}
