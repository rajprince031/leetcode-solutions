class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<Integer>[] arr = new ArrayList[n];
        for(int i=0; i<n; i++) 
            arr[i] = new ArrayList<Integer>();

        for(int[] ele : prerequisites){
            arr[ele[0]].add(ele[1]);
        }
        int[] vis = new int[n];
        boolean ans = true;
        for(int i=0; i<n; i++){
            if(vis[i] != 1) {
                ans = solve(arr, vis, i);
            }
            if(!ans) return ans;
        }
        return ans;
    }
    public boolean solve(ArrayList<Integer>[] arr, int[] vis, int idx){
        vis[idx] = -1;

        boolean flag = true;
        for(int i : arr[idx]){
            if(vis[i] == 1) continue;
            if(vis[i] == -1 ) return false;
            if(!solve(arr, vis, i))return false;
        }
        if(flag) vis[idx] = 1;
        
        return flag;
    }
}