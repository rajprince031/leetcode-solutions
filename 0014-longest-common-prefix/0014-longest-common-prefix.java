class Solution {
    class TriNode{
        TriNode[] children = new TriNode[26];
        //for(int i=0; i<26; i++) children[i] = null;
    }

    private void insert(TriNode root, String word){
        TriNode pointer = root;
        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if(pointer.children[idx] == null){
                pointer.children[idx] = new TriNode();
            }
            pointer = pointer.children[idx];
        }
    }
    private String minInsert(TriNode root, String word){
        String count = "";
        TriNode pointer = root;
        int n = word.length();
        for(int i=0; i<n; i++){
            int idx = word.charAt(i) - 'a';
            if(pointer.children[idx] == null) {
                break;
            }
            count = count + word.charAt(i);
            pointer = pointer.children[idx];
        }
        pointer.children = new TriNode[26];
        return count;
    }
    public String longestCommonPrefix(String[] strs) {
        TriNode root = new TriNode();
        insert(root, strs[0]);
        if(strs.length == 1) return strs[0];
        String answer = "";
        for(String word : strs){
            answer = minInsert(root, word);
        }
        return answer;
    }
}