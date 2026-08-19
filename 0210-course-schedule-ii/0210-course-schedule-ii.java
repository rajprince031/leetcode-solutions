class Solution {
    public int[] findOrder(int numCourses, int[][] prr) {
        int n = numCourses;
        ArrayList<Integer>[] arr = new ArrayList[n];
        for(int i=0; i<n; i++) arr[i] = new ArrayList<Integer>();
        for(int[] ele : prr){
            arr[ele[0]].add(ele[1]);
        }
        boolean isPossible = true;
        HashSet<Integer> list = new HashSet<>();
        ArrayList<Integer> ls = new ArrayList<>();
        for(int i=0; i<n; i++){
            boolean[] vis = new boolean[n];
            isPossible = solve(arr, list, ls, vis, i, isPossible);
            if(!isPossible) return new int[]{};
            if(list.size() == n){
                int[] ans = ls.stream().mapToInt(Integer::intValue).toArray();
                return ans;
            }
        }
        return new int[]{};
    }

    public boolean solve(ArrayList<Integer>[] arr,HashSet<Integer> list,ArrayList<Integer> ls,boolean[] vis, int idx, boolean isPossible){
        vis[idx] = true;
        for(int ele : arr[idx]){
            if(!vis[ele]) isPossible = solve(arr, list, ls, vis, ele, isPossible);
            else {
                System.out.println("imp" +vis[ele] + " "+ ele);
                if(!list.contains(ele)) return false;
            }
        }
        System.out.println(idx +" "+vis[idx]);
        if(!list.contains(idx)) ls.add(idx);
        list.add(idx);
        return isPossible;
    }
}