class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int low = 0;
        int high = 0;
        int max = 0;
        while(high != n){
            char hh = s.charAt(high);
            while(set.contains(hh)){
                char ll = s.charAt(low);
                set.remove(ll);
                low++;
            }
            set.add(hh);
            max = Math.max(high - low + 1, max);
            high++;
        }
        return max;
    }
}