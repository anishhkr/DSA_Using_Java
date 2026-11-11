class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth,
                            int need1, int need2) {

        long ans = Long.MAX_VALUE;
        int[] candidates = {
            0,
            need1,
            need2,
            Math.max(need1, need2)
        };

        for (int x : candidates) {
            long cur = 1L * x * costBoth
                    + 1L * Math.max(0, need1 - x) * cost1
                    + 1L * Math.max(0, need2 - x) * cost2;

            ans = Math.min(ans, cur);
        }
        return ans;
    }
}