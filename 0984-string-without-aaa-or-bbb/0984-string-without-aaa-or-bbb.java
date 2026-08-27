class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        while(a>0 || b>0){
            int n = sb.length();
            boolean putA;
            if(n>=2 && sb.charAt(n-1)==sb.charAt(n-2)){
                putA = sb.charAt(n-1) == 'b';
            }else putA = a >= b;

            if(putA){
                sb.append('a');
                a--;
            }else{
                sb.append('b');
                b--;
            }
        }
        return sb.toString();
    }
}