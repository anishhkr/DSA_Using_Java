class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int ans = 0;
        int[][] signs = {
            {1, 1},
            {1, -1},
            {-1, 1},
            {-1, -1}
        };

        for (int[] s : signs) {
            int mx = Integer.MIN_VALUE;
            int mn = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int value = s[0] * arr1[i] + s[1] * arr2[i] + i;
                mx = Math.max(mx, value);
                mn = Math.min(mn, value);
            }
            ans = Math.max(ans, mx - mn);
        }
        return ans;
    }
}