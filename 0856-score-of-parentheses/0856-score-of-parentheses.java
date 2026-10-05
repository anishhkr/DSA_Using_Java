import java.util.*;

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // base score

        for (char ch : s.toCharArray()) {
            if (ch == '(') stack.push(0);
            else {
                int curr = stack.pop();
                if (curr == 0) curr = 1;
                else curr *= 2;
                stack.push(stack.pop() + curr);
            }
        }
        return stack.pop();
    }
}