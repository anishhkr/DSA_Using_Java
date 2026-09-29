class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        String middle = "";

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                middle = String.valueOf((char) (i + 'a'));
                freq[i]--;
                break;
            }
        }

        StringBuilder left = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            int count = freq[i] / 2;
            while (count-- > 0) {
                left.append((char) (i + 'a'));
            }
        }

        String right = new StringBuilder(left).reverse().toString();

        return left.toString() + middle + right;
    }
}