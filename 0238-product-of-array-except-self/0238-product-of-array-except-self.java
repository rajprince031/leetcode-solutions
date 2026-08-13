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
        if(zeroCount > 1) {
            Arrays.fill(nums, 0);
            return nums;
        }
        if(zeroCount == 1) {
            Arrays.fill(nums, 0);
            nums[idx] = product;
            return nums;
        }
        for(int i=0; i<n; i++){
            nums[i] = product / nums[i];   
        }
        return nums;
    }
}