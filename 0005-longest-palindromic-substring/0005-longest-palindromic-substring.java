class Solution {
    public String solve(String s){
        String max = "";
        for(int i=0; i<s.length(); i++){
            int l = i;
            int r = i;
            while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }
            if((r - l) > max.length()) max = s.substring(l+1,r);
            l = i;
            r = i+1;
            while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }
            if((r - l) > max.length()) max = s.substring(l+1,r);
        }
        return max;
    }
    public String longestPalindrome(String s) {
        return solve(s);
    }
}