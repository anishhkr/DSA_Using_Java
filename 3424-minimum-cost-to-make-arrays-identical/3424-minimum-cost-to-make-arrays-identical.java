class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        int n = arr.length;
        
        long costWithoutRearrange = 0;
        for (int i = 0; i < n; i++) {
            costWithoutRearrange += Math.abs((long) arr[i] - brr[i]);
        }
        
        int[] sortedArr = arr.clone();
        int[] sortedBrr = brr.clone();
        Arrays.sort(sortedArr);
        Arrays.sort(sortedBrr);
        
        long costWithRearrange = k;
        for (int i = 0; i < n; i++) {
            costWithRearrange += Math.abs((long) sortedArr[i] - sortedBrr[i]);
        }
        
        return Math.min(costWithoutRearrange, costWithRearrange);
    }
}