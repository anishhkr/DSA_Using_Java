class Solution {
    public int numOfSubarrays(int[] arr) {
        long MOD = 1_000_000_007;

        long evenCount = 1;
        long oddCount = 0;
        long prefixSum = 0;
        int answer = 0;

        for (int num : arr) {
            prefixSum += num;

            if (prefixSum % 2 == 0) {
                answer += oddCount;
                answer %= MOD;
                evenCount++;
            } else {
                answer += evenCount;
                answer %= MOD;
                oddCount++;
            }
        }
        return answer;
    }
}