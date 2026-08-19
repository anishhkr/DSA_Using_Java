class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] seat : reservedSeats){
            map.computeIfAbsent(seat[0], k -> new HashSet<>()).add(seat[1]);
        }
        int result = 0;
        for(int row : map.keySet()){
            Set<Integer> reserved = map.get(row);
            boolean blockA = !(reserved.contains(2) || reserved.contains(3) || reserved.contains(4) || reserved.contains(5));
            boolean blockB = !(reserved.contains(4) || reserved.contains(5) || reserved.contains(6) || reserved.contains(7));
            boolean blockC = !(reserved.contains(6) || reserved.contains(7) || reserved.contains(8) || reserved.contains(9));
            if(blockA && blockC) result += 2;
            else if(blockA || blockB || blockC) result += 1;
        }
        result += (n - map.size()) * 2;
        return result;
    }
}