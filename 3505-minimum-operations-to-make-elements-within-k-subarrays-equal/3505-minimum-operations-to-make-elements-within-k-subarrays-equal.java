import java.util.*;

class Solution {
    class MedianWindow {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        long leftSum = 0;
        long rightSum = 0;
        int leftSize = 0;
        int rightSize = 0;

        private void addMap(TreeMap<Integer, Integer> map, int x) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        private void removeMap(TreeMap<Integer, Integer> map, int x) {
            int cnt = map.get(x);
            if (cnt == 1) map.remove(x);
            else map.put(x, cnt - 1);
        }

        void add(int x) {
            if (leftSize == 0 || x <= left.lastKey()) {
                addMap(left, x);
                leftSum += x;
                leftSize++;
            } else {
                addMap(right, x);
                rightSum += x;
                rightSize++;
            }
            balance();
        }

        void remove(int x) {
            if (left.containsKey(x)) {
                removeMap(left, x);
                leftSum -= x;
                leftSize--;
            } else {
                removeMap(right, x);
                rightSum -= x;
                rightSize--;
            }
            balance();
        }

        void balance() {
            while (leftSize > rightSize + 1) {
                int val = left.lastKey();
                removeMap(left, val);
                leftSum -= val;
                leftSize--;
                addMap(right, val);
                rightSum += val;
                rightSize++;
            }

            while (leftSize < rightSize) {
                int val = right.firstKey();
                removeMap(right, val);
                rightSum -= val;
                rightSize--;
                addMap(left, val);
                leftSum += val;
                leftSize++;
            }
        }

        long getCost() {
            int median = left.lastKey();
            long leftCost =
                    1L * median * leftSize - leftSum;
            long rightCost =
                    rightSum - 1L * median * rightSize;
            return leftCost + rightCost;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];
        MedianWindow mw = new MedianWindow();
        for (int i = 0; i < n; i++) {
            mw.add(nums[i]);
            if (i >= x) {
                mw.remove(nums[i - x]);
            }
            if (i >= x - 1) {
                cost[i - x + 1] = mw.getCost();
            }
        }
        long[][] dp = new long[n + 1][k + 1];
        for (long[] row : dp) {
            Arrays.fill(row, (long) 1e18);
        }

        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j > 0 && i >= x) {
                    dp[i][j] = Math.min(
                            dp[i][j],
                            dp[i - x][j - 1] + cost[i - x]
                    );
                }
            }
        }
        return dp[n][k];
    }
}