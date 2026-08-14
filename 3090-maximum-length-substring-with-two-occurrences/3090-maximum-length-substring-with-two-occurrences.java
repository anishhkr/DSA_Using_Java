class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int left=0, maxLen=0;
        for(int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0)+1);
            while(freq.get(c)>2){
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar)-1);
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}