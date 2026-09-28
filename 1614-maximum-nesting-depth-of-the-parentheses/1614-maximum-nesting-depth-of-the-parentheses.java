class Solution {
    public int maxDepth(String s) {
        int currDepth = 0, maxDepth = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                currDepth++;
                maxDepth = Math.max(maxDepth, currDepth);
            } else if(ch == ')') currDepth--;
        }
        return maxDepth;
    }
}