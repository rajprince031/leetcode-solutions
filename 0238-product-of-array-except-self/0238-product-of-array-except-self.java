class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int zeroCount = 0;
        int idx = -1;
        int product = 1;
        for(int i=0; i<n; i++){
            if(nums[i] == 0) {
                zeroCount++;
                idx = i;
            }
            else product *= nums[i];
        }
        int[] answer = new int[n];
        if(zeroCount > 1) return answer;
        if(zeroCount == 1) {
            answer[idx] = product;
            return answer;
        }
        for(int i=0; i<n; i++){
            answer[i] = product / nums[i];   
        }
        return answer;
    }
}