class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;
        int totalN = n + k - 1;
        int totalR = 2 * k;

        if (totalR > totalN) {
            return 0;
        }

        // dp[j] represents C(i, j)
        long[] dp = new long[totalR + 1];
        dp[0] = 1;

        for (int i = 1; i <= totalN; i++) {
            for (int j = Math.min(i, totalR); j > 0; j--) {
                dp[j] = (dp[j] + dp[j - 1]) % MOD;
            }
        }

        return (int) dp[totalR];
    }
}