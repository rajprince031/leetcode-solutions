class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int low = 0;
        int high = 0;
        int max = 0;
        while(high != n){
            char hh = s.charAt(high);
            map.put(hh, map.getOrDefault(hh, 0)+1);
            while(map.get(hh) != 1){
                char ll = s.charAt(low);
                map.put(ll, map.get(ll)-1);
                if(map.get(ll) == 0) map.remove(ll);
                low++;
            }
            max = Math.max(map.size(), max);
            high++;
        }
        return max;
    }
}