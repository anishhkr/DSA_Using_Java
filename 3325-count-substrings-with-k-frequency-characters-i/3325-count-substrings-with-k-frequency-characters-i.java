class Solution {
    public int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int left = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {
            int idx = s.charAt(right) - 'a';
            freq[idx]++;

            while (freq[idx] >= k) {
                ans += (n - right);
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return ans;
    }
}