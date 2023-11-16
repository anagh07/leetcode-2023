package Stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3).toString());
    }

    public static List<String> generateParenthesis(int n) {
        List<String> solution = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        return backTrack(n, 0, 0, stack, solution);
    }

    public static List<String> backTrack(int n, int openCount, int closeCount, Stack<String> stack, List<String> solution) {

        if (openCount == closeCount && openCount == n) {
            solution.add(String.join("", stack));
        }
        if (openCount < n) {
            stack.push("(");
            backTrack(n, openCount + 1, closeCount, stack, solution);
            stack.pop();
        }
        if (closeCount < openCount) {
            stack.push(")");
            backTrack(n, openCount, closeCount + 1, stack, solution);
            stack.pop();
        }

        return solution;
    }
}
