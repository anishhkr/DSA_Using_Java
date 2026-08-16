class Solution {
    public boolean stoneGameIX(int[] stones) {
        int count0 = 0, count1 = 0, count2 = 0;
        for(int s : stones){
            if(s % 3 == 0) count0++;
            else if(s % 3 == 1) count1++;
            else count2++;
        }
        if(count0 % 2 == 0) return count1>0 && count2>0;
        else return Math.abs(count1 - count2) > 2;
    }
}