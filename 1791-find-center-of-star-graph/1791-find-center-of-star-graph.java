class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> arr = new ArrayList<>();
        for(int i=0; i<=n; i++) arr.add(new ArrayList<Integer>());
        // System.out.println("arr size "+arr.size());
        for(int[] edge : edges){
            arr.get(edge[0]).add(edge[1]);
            arr.get(edge[1]).add(edge[0]);
        }
        for(int i=1; i<=n; i++){
            if(arr.get(i).size() == n-1) return i;
        }
        return -1;
    }
}