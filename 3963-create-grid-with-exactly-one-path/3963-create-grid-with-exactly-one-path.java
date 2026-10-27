class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        for (int i = 0; i < m; i++) {
            char[] row = new char[n];
            for (int j = 0; j < n; j++) {
                row[j] = (i == 0 || j == n - 1) ? '.' : '#';
            }
            ans[i] = new String(row);
        }
        return ans;
    }
}