package Stacks;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "()[{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> result = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case ']':
                    if (!result.isEmpty() && result.peek() == '[')
                        result.pop();
                    else
                        result.push(c);
                    break;

                case '}':
                    if (!result.isEmpty() && result.peek() == '{')
                        result.pop();
                    else
                        result.push(c);
                    break;

                case ')':
                    if (!result.isEmpty() && result.peek() == '(')
                        result.pop();
                    else
                        result.push(c);
                    break;

                default:
                    result.push(c);
            }
        }
        return result.isEmpty();
    }
}
