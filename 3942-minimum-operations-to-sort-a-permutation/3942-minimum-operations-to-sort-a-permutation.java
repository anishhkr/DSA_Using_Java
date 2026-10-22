class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int best = Integer.MAX_VALUE;
        boolean asc = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] != (nums[0] + i) % n) {
                asc = false;
                break;
            }
        }
        if (asc) {
            int a = (n - nums[0]) % n;               // left rotations needed
            int cost = (a == 0) ? 0 : Math.min(a, n - a + 2);
            best = Math.min(best, cost);
        }
        boolean desc = true;
        for (int i = 0; i < n; i++) {
            int expected = ((nums[0] - i) % n + n) % n;
            if (nums[i] != expected) {
                desc = false;
                break;
            }
        }
        if (desc) {
            int a = (n - nums[n - 1]) % n;
            best = Math.min(best, 1 + a);
            int idx = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] == n - 1) {
                    idx = i;
                    break;
                }
            }
            best = Math.min(best, idx + 1);
        }
        return best == Integer.MAX_VALUE ? -1 : best;
    }
}