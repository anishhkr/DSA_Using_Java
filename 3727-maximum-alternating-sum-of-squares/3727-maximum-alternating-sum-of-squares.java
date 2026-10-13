import java.util.*;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] sq = new long[n];
        for (int i = 0; i < n; i++) {
            sq[i] = 1L * nums[i] * nums[i];
        }

        Arrays.sort(sq);
        long ans = 0;
        int neg = n / 2;
        for (int i = 0; i < neg; i++) {
            ans -= sq[i];
        }
        for (int i = neg; i < n; i++) {
            ans += sq[i];
        }
        return ans;
    }
}