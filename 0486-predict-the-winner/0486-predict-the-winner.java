class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][n];
        return helper(nums, 0, n-1, dp) >= 0;
    }
    private int helper(int[] nums, int l, int r, Integer[][] dp){
        if(l==r) return nums[l];
        if(dp[l][r] != null) return dp[l][r];
        
        int takeLeft = nums[l] - helper(nums, l+1, r, dp);
        int takeRight = nums[r] - helper(nums, l, r-1, dp);
        dp[l][r] = Math.max(takeLeft, takeRight);
        return dp[l][r];
    }
}