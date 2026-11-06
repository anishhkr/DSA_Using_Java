import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        int m = queries.length;
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        int[] ans = new int[m];
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        int right = 0;
        int activeServers = 0;

        for (int[] q : sortedQueries) {
            int time = q[0];
            while (right < logs.length && logs[right][1] <= time) {
                int server = logs[right][0];
                int count = freq.getOrDefault(server, 0);
                if (count == 0) activeServers++;
                freq.put(server, count + 1);
                right++;
            }

            while (left < logs.length && logs[left][1] < time - x) {
                int server = logs[left][0];
                int count = freq.get(server) - 1;
                if (count == 0) {
                    freq.remove(server);
                    activeServers--;
                } else {
                    freq.put(server, count);
                }
                left++;
            }
            ans[q[1]] = n - activeServers;
        }
        return ans;
    }
}