class Solution {
    public int minimumFlips(int n) {
        String s = Integer.toBinaryString(n);
        int len = s.length();
        int flips = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                flips++;
            }
        }
        return flips;
    }
}