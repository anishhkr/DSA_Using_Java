class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        StringBuilder result = new StringBuilder();
        if (dfs(0, target, freq, result)) return result.toString();
        return "";
    }

    private static boolean dfs(int idx, String target, int[] freq, StringBuilder result) {
        if (idx == target.length()) {
            return result.toString().compareTo(target) > 0;
        }

        int t = target.charAt(idx) - 'a';

        if (freq[t] > 0) {
            result.append((char)(t + 'a'));
            freq[t]--;
            if (dfs(idx + 1, target, freq, result)) return true;
            freq[t]++;
            result.deleteCharAt(result.length() - 1);
        }

        for (int c = t + 1; c < 26; c++) {
            if (freq[c] > 0) {
                result.append((char)(c + 'a'));
                freq[c]--;
                for (int i = 0; i < 26; i++) {
                    while (freq[i]-- > 0) {
                        result.append((char)(i + 'a'));
                    }
                }
                return true;
            }
        }
        return false;
    }
}
