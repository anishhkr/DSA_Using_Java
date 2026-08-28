class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        int oddCount = 0;
        int oddChar = -1;
        for (int c = 0; c < 26; c++) {
            if (count[c] % 2 != 0) {
                oddCount++;
                oddChar = c;
            }
        }

        if (oddCount > 1 || (n % 2 == 0 && oddCount != 0)) {
            return "";
        }

        int[] halfCount = new int[26];
        for (int c = 0; c < 26; c++) {
            halfCount[c] = count[c] / 2;
        }

        int halfLen = n / 2;
        char[] result = new char[n];

        if (n % 2 != 0) {
            result[halfLen] = (char) ('a' + oddChar);
        }

        int[] curHalf = halfCount.clone();
        boolean prefixMatches = true;

        for (int i = 0; i < halfLen; i++) {
            int c = target.charAt(i) - 'a';
            if (curHalf[c] > 0) {
                curHalf[c]--;
                result[i] = (char) ('a' + c);
                result[n - 1 - i] = result[i];
            } else {
                prefixMatches = false;
                break;
            }
        }

        if (prefixMatches) {
            String candidate = new String(result);
            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        for (int i = halfLen - 1; i >= 0; i--) {
            curHalf = halfCount.clone();
            boolean validPrefix = true;
            for (int j = 0; j < i; j++) {
                int c = target.charAt(j) - 'a';
                if (curHalf[c] > 0) {
                    curHalf[c]--;
                    result[j] = (char) ('a' + c);
                    result[n - 1 - j] = result[j];
                } else {
                    validPrefix = false;
                    break;
                }
            }

            if (!validPrefix) {
                continue;
            }

            int targetChar = target.charAt(i) - 'a';
            for (int c = targetChar + 1; c < 26; c++) {
                if (curHalf[c] > 0) {
                    curHalf[c]--;
                    result[i] = (char) ('a' + c);
                    result[n - 1 - i] = result[i];

                    int fillIdx = i + 1;
                    for (int fillChar = 0; fillChar < 26; fillChar++) {
                        while (curHalf[fillChar] > 0) {
                            result[fillIdx] = (char) ('a' + fillChar);
                            result[n - 1 - fillIdx] = result[fillIdx];
                            fillIdx++;
                            curHalf[fillChar]--;
                        }
                    }

                    return new String(result);
                }
            }
        }

        return "";
    }
}