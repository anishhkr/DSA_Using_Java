class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0]; // prefix sum start
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]+1){
                sum += nums[i]; // add if sequence continues
            }else break; // stop if sequence breaks
        }
        Set<Integer> set = new HashSet<>(); // store all nums
        for(int num: nums) set.add(num);
        int x = sum; // candidate answer
        while(set.contains(x)) x++; // find first missing
        return x;
    }
}
