class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] outward = new int[n+1];
        int[] inward = new int[n+1];
        for(int[] ele : trust){
            outward[ele[0]]++;
            inward[ele[1]]++;
        }
        for(int i=1; i<=n; i++){
            if(inward[i] == n-1 && outward[i] == 0) return i;
        }

        return -1;
    }
    
}