class Solution {
    public int countCommas(int n) {
        int count = 0;
        if (n >= 1000) {
            count += Math.min(n, 999_999) - 999;
        }
        if (n >= 1_000_000) {
            count += (Math.min(n, 999_999_999) - 999_999) * 2;
        }
        if (n >= 1_000_000_000) {
            count += (Math.min(n, 999_999_999_999L) - 999_999_999) * 3;
        }
        if (n >= 1_000_000_000_000L) {
            count += (Math.min(n, 999_999_999_999_999L) - 999_999_999_999L) * 4;
        }
        if (n >= 1_000_000_000_000_000L) {
            count += (Math.min(n, 999_999_999_999_999_999L) - 999_999_999_999_999L) * 5;
        }

        return count;
    }
}
