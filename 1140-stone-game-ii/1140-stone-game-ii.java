class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }
        Map<String, Integer> memo = new HashMap<>();
        return dfs(0, 1, piles, suffix, memo);
    }

    private int dfs(int i, int M, int[] piles, int[] suffix, Map<String, Integer> memo) {
        if (i >= piles.length) return 0;

        String key = i + "," + M;
        if (memo.containsKey(key)) return memo.get(key);

        int n = piles.length;
        int best = 0;

        for (int X = 1; X <= 2 * M && i + X <= n; X++) {
            best = Math.max(best, suffix[i] - dfs(i + X, Math.max(M, X), piles, suffix, memo));
        }

        memo.put(key, best);
        return best;
    }
}