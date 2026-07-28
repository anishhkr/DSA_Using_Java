class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for(char ch: s.toCharArray()){ //Count frequency
            freq[ch-'a']++;
        }
        //Find middle chararcter (if odd frequency)
        String middle = "";
        for(int i=0; i<26; i++){
            if(freq[i]%2 == 1){
                middle = String.valueOf((char)(i+'a'));
                freq[i]--;
                break;
            }
        }
        //Create left half
        StringBuilder left = new StringBuilder();
        for(int i=0; i<26; i++){
            int count = freq[i]/2;
            for(int j=0; j<count; j++){
                left.append((char)(i+'a'));
            }
        }
        //Create right half (reverse of left)
        String right = new StringBuilder(left).reverse().toString();

        return left.toString() + middle + right; //Final palindrome
    }
}