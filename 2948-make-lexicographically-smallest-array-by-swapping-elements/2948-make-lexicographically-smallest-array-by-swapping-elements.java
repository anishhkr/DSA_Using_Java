class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i]; // value
            arr[i][1] = i;       // original index
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> groups = new ArrayList<>();
        List<List<Integer>> indices = new ArrayList<>();

        List<Integer> currentGroup = new ArrayList<>();
        List<Integer> currentIndices = new ArrayList<>();

        currentGroup.add(arr[0][0]);
        currentIndices.add(arr[0][1]);

        for (int i = 1; i < n; i++) {
            if (arr[i][0] - arr[i - 1][0] <= limit) {
                currentGroup.add(arr[i][0]);
                currentIndices.add(arr[i][1]);
            } else {
                groups.add(new ArrayList<>(currentGroup));
                indices.add(new ArrayList<>(currentIndices));
                currentGroup.clear();
                currentIndices.clear();
                currentGroup.add(arr[i][0]);
                currentIndices.add(arr[i][1]);
            }
        }
        groups.add(currentGroup);
        indices.add(currentIndices);

        int[] result = new int[n];
        for (int g = 0; g < groups.size(); g++) {
            List<Integer> vals = groups.get(g);
            List<Integer> idxs = indices.get(g);

            Collections.sort(idxs);
            Collections.sort(vals);

            for (int i = 0; i < idxs.size(); i++) {
                result[idxs.get(i)] = vals.get(i);
            }
        }

        return result;
    }
}