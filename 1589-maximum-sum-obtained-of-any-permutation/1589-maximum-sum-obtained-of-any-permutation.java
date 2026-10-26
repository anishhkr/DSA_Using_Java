import java.util.*;

class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        long mod = 1_000_000_007L;
        long[] freq = new long[n + 1];
        for (int[] req : requests) {
            int l = req[0];
            int r = req[1];
            freq[l]++;
            if (r + 1 < n) freq[r + 1]--;
        }
        for (int i = 1; i < n; i++) freq[i] += freq[i - 1];
        long[] count = new long[n];
        for (int i = 0; i < n; i++) count[i] = freq[i];
        Arrays.sort(nums);
        Arrays.sort(count);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (count[i] * nums[i]) % mod) % mod;
        }
        return (int) ans;
    }
}