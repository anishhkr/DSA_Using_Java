import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(s);
        visited.add(s);
        boolean found = false;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (isValid(cur)) {
                    ans.add(cur);
                    found = true;
                }
                if (found) continue;
                for (int j = 0; j < cur.length(); j++) {
                    char ch = cur.charAt(j);
                    if (ch != '(' && ch != ')') continue;
                    String next =
                            cur.substring(0, j)
                                    + cur.substring(j + 1);

                    if (visited.add(next)) {
                        q.offer(next);
                    }
                }
            }
            if (found) break;
        }
        return ans;
    }

    private boolean isValid(String s) {
        int balance = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') balance++;
            else if (ch == ')') {
                balance--;
                if (balance < 0) return false;
            }
        }
        return balance == 0;
    }
}