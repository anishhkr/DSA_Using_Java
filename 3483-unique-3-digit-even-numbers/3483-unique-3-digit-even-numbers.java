class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for(int d : digits) freq[d]++;
        Set<Integer> set = new HashSet<>();
        for(int num=100; num<=999; num+=2){
            int a = num/100, b = (num/10)%10, c = num%10;
            int[] need = new int[10];
            need[a]++; need[b]++; need[c]++;

            boolean ok = true;
            for(int d=0; d<10; d++){
                if(need[d] > freq[d]){
                    ok = false;
                    break;
                }
            }
            if(ok) set.add(num);
        }
        return set.size();
    }
}