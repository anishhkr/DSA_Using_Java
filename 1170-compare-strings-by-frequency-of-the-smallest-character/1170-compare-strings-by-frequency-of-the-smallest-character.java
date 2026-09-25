import java.util.*;

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = words.length;
        int[] freqWords = new int[n];

        for(int i = 0; i < n; i++) {
            freqWords[i] = frequency(words[i]);
        }

        Arrays.sort(freqWords);
        int[] ans = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {
            int qFreq = frequency(queries[i]);
            int idx = upperBound(freqWords, qFreq);
            ans[i] = n - idx;
        }
        return ans;
    }

    private int frequency(String s) {
        char smallest = 'z';
        int count = 0;

        for(char ch : s.toCharArray()) {
            if(ch < smallest) {
                smallest = ch;
                count = 1;
            } else if(ch == smallest) count++;
        }
        return count;
    }

    private int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}