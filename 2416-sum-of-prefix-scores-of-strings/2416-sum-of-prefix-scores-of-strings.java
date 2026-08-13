class Solution {

    class Tri{
        int count;
        Tri[] child = new Tri[26];
        public Tri(){
            for(int i=0; i<26; i++){
                child[i] = null;
            }
            count = 0;
        }
    }
    private void insert(Tri root, String word){
        int idx = 0;
        Tri run = root;
        while(idx != word.length()){
            int ch = word.charAt(idx) - 'a';
            
            if(run.child[ch] == null) {
                run.child[ch] = new Tri();
            }
            run.child[ch].count += 1;
            run = run.child[ch];
            idx++;
        }
    }
    private int getScore(Tri root, String word){
        int score = 0;
        Tri run = root;
        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            score += run.child[idx].count;
            run = run.child[idx];
        }
        return score;
    }
    public int[] sumPrefixScores(String[] words) {
        Tri root = new Tri();
        int n = words.length;
        int[] answer = new int[n];
        int idx = 0;
        for(String s : words){
            insert(root, s);
        }

        for(int i=0; i<n; i++){
            answer[i] = getScore(root, words[i]);
        }
        return answer;

    }
}