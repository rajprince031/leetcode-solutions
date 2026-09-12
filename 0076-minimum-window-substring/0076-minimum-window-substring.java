class Solution {
    public String minWindow(String s, String t) {
        int n1 = t.length();
        int n2 = s.length();
        if(n1 > n2 ) return "";
        HashMap<Character, Integer> map1 = countMap(t);
        HashMap<Character, Integer> map2 = new HashMap<>();
        int low = 0;
        int high = 0;
        StringBuilder sb = new StringBuilder("");
        String ans = s;
        boolean flag = true;
        while(high != n2){
            if(!compare(map1, map2)){
                char ch = s.charAt(high);
                map2.put(ch, map2.getOrDefault(ch, 0)+1);
                sb.append(ch);
                high++;
            }else{
                flag = false;
                if(sb.length() <= ans.length()) ans = sb.toString();
                char ch = s.charAt(low);
                map2.put(ch, map2.get(ch)-1);
                if(map2.get(ch) == 0) map2.remove(ch);
                sb.deleteCharAt(0);
                low++;
            }
        }
        while(compare(map1, map2)){
            flag = false;
            if(sb.length() < ans.length()) ans = sb.toString();
            char ch = s.charAt(low);
            map2.put(ch, map2.get(ch)-1);
            if(map2.get(ch) == 0) map2.remove(ch);
            sb.deleteCharAt(0);
            low++;
        }
        return (flag ? "" : ans);
    }
    public HashMap<Character, Integer> countMap(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        return map;
    }
    public boolean compare(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2){
        for(Character ch : map1.keySet()){
            if(!map2.containsKey(ch) || map1.get(ch) > map2.get(ch)) return false;
        }
        return true;
    }
}