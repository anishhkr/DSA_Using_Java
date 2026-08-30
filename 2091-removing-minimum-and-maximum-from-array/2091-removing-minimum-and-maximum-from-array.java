class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minIndex = 0, maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIndex]) minIndex = i;
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }

        if (minIndex > maxIndex) {
            int temp = minIndex;
            minIndex = maxIndex;
            maxIndex = temp;
        }

        int option1 = maxIndex + 1;
        int option2 = n - minIndex;
        int option3 = (minIndex + 1) + (n - maxIndex);

        return Math.min(option1, Math.min(option2, option3));
    }
}
