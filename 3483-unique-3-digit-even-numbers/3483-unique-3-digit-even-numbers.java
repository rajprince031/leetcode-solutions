class Solution {
    public int totalNumbers(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[1000];
        int ans = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == 0) continue;
            for(int j=0; j<n; j++){
                if(i == j) continue;
                for(int k=0; k<n; k++){
                    if(j==k || k==i || nums[k] % 2 != 0) continue;
                    int temp = (nums[i] * 100) + (nums[j] * 10) + nums[k];
                    if(!vis[temp]) {
                        vis[temp] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}