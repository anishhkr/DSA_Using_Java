class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<Integer> ones = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1') ones.add(i);
        }
        if(ones.size() < k) return "";

        String ans = "";
        for(int i=0; i+k-1 < ones.size(); i++){
            int start = ones.get(i);
            int end = ones.get(i + k - 1);
            String current = s.substring(start, end+1);

            if(ans.isEmpty() || current.length() < ans.length()) ans = current;
            else if(current.length() == ans.length() && current.compareTo(ans) < 0){
                ans = current;
            }
        }
        return ans;
    }
}