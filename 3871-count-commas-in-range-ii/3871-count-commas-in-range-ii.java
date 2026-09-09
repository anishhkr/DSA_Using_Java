class Solution {
    public long countCommas(long n) {
        long total = 0;
        for (int k = 3; ; k += 3) {
            long lower = (long) Math.pow(10, k);
            if (lower > n) break;

            long upper = Math.min(n, (long) Math.pow(10, k + 3) - 1);
            long count = upper - lower + 1;
            total += count * (k / 3);
        }

        return total;
    }
}