class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> subarrayCount = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i =0; i<k; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        for(int val : freq.keySet()){
            subarrayCount.put(val, subarrayCount.getOrDefault(val, 0) + 1);
        }
        for(int i=k; i<n; i++){
            int out = nums[i - k];
            int in = nums[i];
            freq.put(out, freq.get(out) - 1);
            if(freq.get(out) == 0) freq.remove(out);

            freq.put(in, freq.getOrDefault(in, 0) + 1);
            for(int val: freq.keySet()){
                subarrayCount.put(val, subarrayCount.getOrDefault(val, 0) + 1);
            }
        }

        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : subarrayCount.entrySet()) {
            if (entry.getValue() == 1) {
                ans = Math.max(ans, entry.getKey());
            }
        }
        return ans;
    }
}