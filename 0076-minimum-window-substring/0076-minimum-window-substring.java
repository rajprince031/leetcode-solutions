class Solution {
    public boolean compare(HashMap<Character, Integer> arr, HashMap<Character, Integer> brr){
        for(Map.Entry<Character, Integer> ele : arr.entrySet()){
            char key = ele.getKey();
            int value = ele.getValue();
            if(!brr.containsKey(key)) return false;
            if(brr.get(key) < value) return false;
            
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if(n2 > n1) return "";
        HashMap<Character, Integer> arr = new HashMap<>();
        HashMap<Character, Integer> brr = new HashMap<>();
        for(int i=0; i<n2; i++) {
            arr.put(t.charAt(i),arr.getOrDefault(t.charAt(i),0)+1);
        }
        int low = 0;
        int high = 0;
        int maxLength = n1;
        String ans = "";
        while(high != n1){
            char hch = s.charAt(high);
            brr.put(hch, brr.getOrDefault(hch,0)+1);
            high++;
                //System.out.println(compare(arr,brr));
                //System.out.println("high"+" "+hch);
            while(compare(arr, brr) && low <= high){
                char lch = s.charAt(low);
                //System.out.println("low"+" "+lch);
                int len = high - low;
                if(len <= maxLength){
                    ans = s.substring(low, high);
                    maxLength = ans.length();
                }
                //System.out.println("ans " + ans);
                brr.put(lch, brr.getOrDefault(lch,0)-1);
                if(brr.get(lch) == 0) brr.remove(lch);
                low++;
            }
            
            //System.out.println("maxLength  "+ maxLength);
        } 
        return ans;    
    }
}