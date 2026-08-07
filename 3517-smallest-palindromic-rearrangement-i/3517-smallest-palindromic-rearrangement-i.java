class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        if(n==1) return s;
        int[] arr = new int[26];
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            arr[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int isOdd = -1;
        for(int i=0; i<26; i++){
            if(arr[i] % 2 == 1) isOdd = i;
            int temp = arr[i] / 2;
            while(temp -- > 0){
                char cc = (char)('a' + i);
                sb.append(cc);
            }
        }
        String ans = sb.toString();
        if(isOdd == -1) return ans + (sb.reverse()).toString();
        char cc = (char)('a' + isOdd);
        return ans + cc +(sb.reverse()).toString();

    }
}