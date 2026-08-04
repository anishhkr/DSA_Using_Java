class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++){
            int prev = nums[i-1];
            int curr = nums[i];
            for(int j=prev+1; j<curr; j++) result.add(j);
        }
        return result;
    }
}