class Solution {
    public int findCenter(int[][] edges) {
        int[] fe = edges[0];
        int[] se = edges[1];
        if(fe[0] == se[0] || fe[0] == se[1]) return fe[0];
        return fe[1];
    }
}