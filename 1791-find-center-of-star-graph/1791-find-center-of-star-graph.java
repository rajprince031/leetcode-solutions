class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] arr = new int[n+2];
        for(int[] edge : edges){
            arr[edge[0]]++;
            arr[edge[1]]++;
        }
        for(int i=1; i<=n; i++){
            if(arr[i] == n-1) return i;
        }
        return -1;
    }
}